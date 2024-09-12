package dev.lukaszmichalak.regionalproducts.count;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class CountRepositoryImpl implements CountRepository {
    
    private final CountRowMapper countRowMapper;
    private final JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Count> getCounts() {
        
        var sql = """
                SELECT v.name AS voivodeship_name, COUNT(p.id) AS product_count
                FROM voivodeship v
                LEFT JOIN product p ON v.id = p.voivodeship_id
                GROUP BY v.name;
                """;
        
        return jdbcTemplate.query(sql, countRowMapper);
    }
}
