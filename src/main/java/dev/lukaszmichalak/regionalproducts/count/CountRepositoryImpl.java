package dev.lukaszmichalak.regionalproducts.count;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class CountRepositoryImpl implements CountRepository {

  private final CountRowMapper countRowMapper;
  private final JdbcTemplate jdbcTemplate;

  private static final String countsSql =
      """
      SELECT v.name AS voivodeship_name, COUNT(p.id) AS product_count
      FROM voivodeship AS v
      LEFT JOIN product AS p ON v.id = p.voivodeship_id
      GROUP BY v.name;
      """;

  @Override
  public List<Count> getCounts() {
    return jdbcTemplate.query(countsSql, countRowMapper);
  }
}
