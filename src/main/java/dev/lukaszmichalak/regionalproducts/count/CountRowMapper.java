package dev.lukaszmichalak.regionalproducts.count;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
class CountRowMapper implements RowMapper<Count> {

  @Override
  public Count mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Count(rs.getString("voivodeship_name"), rs.getLong("product_count"));
  }
}
