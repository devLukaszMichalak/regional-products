package dev.lukaszmichalak.importer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

class DbCacheFactory {

  private static final String SELECT_ALL_VOIVODESHIPS_SQL = "SELECT id, name FROM voivodeship";
  private static final String SELECT_ALL_PRODUCT_TYPES_SQL = "SELECT id, name FROM product_type";

  static DbCache get(Connection connection) throws SQLException {

    Statement selectVoivodeshipsStmt = connection.createStatement();
    Statement selectProductTypesStmt = connection.createStatement();

    Map<String, Long> voivodeshipMap =
        loadFromDb(selectVoivodeshipsStmt, SELECT_ALL_VOIVODESHIPS_SQL);

    Map<String, Long> productTypeMap =
        loadFromDb(selectProductTypesStmt, SELECT_ALL_PRODUCT_TYPES_SQL);

    return new DbCache(voivodeshipMap, productTypeMap);
  }

  private static Map<String, Long> loadFromDb(
      Statement selectVoivodeshipsStmt, String selectAllVoivodeshipsSql) throws SQLException {

    Map<String, Long> voivodeshipMap = new HashMap<>();
    ResultSet voivodeshipResult = selectVoivodeshipsStmt.executeQuery(selectAllVoivodeshipsSql);

    while (voivodeshipResult.next()) {
      voivodeshipMap.put(voivodeshipResult.getString("name"), voivodeshipResult.getLong("id"));
    }

    return voivodeshipMap;
  }
}
