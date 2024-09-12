package dev.lukaszmichalak.regionalproducts.count;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class CountRowMapper implements RowMapper<Count> {
    
    @Override
    public Count mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Count(
                rs.getString("voivodeship_name"),
                rs.getLong("product_count")
        );
    }
    
}
