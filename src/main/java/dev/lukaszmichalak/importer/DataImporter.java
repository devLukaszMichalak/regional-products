package dev.lukaszmichalak.importer;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataImporter {

  private static final String DATABASE_URL = "jdbc:sqlite:regional-products.db";

  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {

      connection.setAutoCommit(false);

      DbCache dataCache = DbCacheFactory.get(connection);

      FileInputStream file = new FileInputStream("Produkty_regionalne_stan_na_30_07_2024_r.xlsx");
      Workbook workbook = new XSSFWorkbook(file);
      Sheet sheet = workbook.getSheetAt(0);

      ExcelExtractor excelExtractor = new ExcelExtractor(sheet);
      DbInserter dbInserter = new DbInserter(dataCache, connection);

      for (ExcelProduct excelProduct : excelExtractor.extract()) {
        dbInserter.insert(excelProduct);
      }

      commitAndClose(connection, workbook, file);

    } catch (SQLException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void commitAndClose(Connection connection, Workbook workbook, FileInputStream file)
      throws SQLException, IOException {
    connection.commit();
    connection.close();
    workbook.close();
    file.close();
  }
}
