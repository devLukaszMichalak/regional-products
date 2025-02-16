package dev.lukaszmichalak.importer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DbInserter {

  private static final String INSERT_PRODUCT_TYPE_SQL =
      "INSERT OR IGNORE INTO product_type (name) VALUES (?)";

  private static final String INSERT_PRODUCT_SQL =
      "INSERT INTO product (name, product_type_id, voivodeship_id, date_of_entry) VALUES (?, ?, ?, ?)";

  private final DbCache dataCache;
  private final PreparedStatement productTypeStmt;
  private final PreparedStatement productStmt;

  public DbInserter(DbCache dataCache, Connection connection) {
    this.dataCache = dataCache;

    try {
      productTypeStmt = connection.prepareStatement(INSERT_PRODUCT_TYPE_SQL);
      productStmt = connection.prepareStatement(INSERT_PRODUCT_SQL);
    } catch (SQLException e) {
      throw new RuntimeException("Could not prepare SQL statements!", e);
    }
  }

  void insert(ExcelProduct excelProduct) throws SQLException {
    Optional.ofNullable(dataCache.voivodeshipMap().get(excelProduct.voivodeship()))
        .ifPresentOrElse(
            voivodeshipId -> {
              long productTypeId = insertProductType(dataCache.productTypeMap(), excelProduct);
              insertProduct(excelProduct, productTypeId, voivodeshipId);
            },
            () -> {
              throw new RuntimeException(
                  "Failed to find a voivodeship with name " + excelProduct.voivodeship());
            });
  }

  private void insertProduct(ExcelProduct excelProduct, long productTypeId, Long voivodeshipId) {

    try {
      productStmt.setString(1, excelProduct.productName());
      productStmt.setLong(2, productTypeId);
      productStmt.setLong(3, voivodeshipId);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String formattedDateOfEntry = excelProduct.dateOfEntry().format(formatter);
      productStmt.setString(4, formattedDateOfEntry);
      productStmt.executeUpdate();
    } catch (SQLException e) {
      log.error("Failed to add product data {}!", excelProduct, e);
    }
  }

  private long insertProductType(Map<String, Long> productTypeMap, ExcelProduct excelProduct) {

    return productTypeMap.computeIfAbsent(
        excelProduct.productType(),
        type -> {
          try {
            productTypeStmt.setString(1, type);
            productTypeStmt.executeUpdate();
            ResultSet generatedKeys = productTypeStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
              return generatedKeys.getLong(1);
            } else {
              throw new RuntimeException(
                  "Data of a product type "
                      + type
                      + " was not inserted into a table when there wasn't a key previously present!");
            }

          } catch (SQLException e) {
            throw new RuntimeException("Failed to add product type " + excelProduct + "!", e);
          }
        });
  }
}
