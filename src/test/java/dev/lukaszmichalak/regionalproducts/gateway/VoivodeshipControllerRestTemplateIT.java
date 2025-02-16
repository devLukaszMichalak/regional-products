package dev.lukaszmichalak.regionalproducts.gateway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
@Execution(ExecutionMode.SAME_THREAD)
class VoivodeshipControllerRestTemplateIT {

  @LocalServerPort private int port;

  private String baseUrl;

  @Autowired private TestRestTemplate restTemplate;

  @BeforeEach
  public void setUp() {
    baseUrl = "http://localhost:" + port;
  }

  @Test
  void testGetVoivodeships() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(baseUrl + "/en/voivodeships", String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).isEqualToIgnoringNewLines(ResponseStub.en_voivodeships);
  }

  @Test
  void testLocalizedPlContent() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(baseUrl + "/pl/voivodeships", String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).contains("WOJEWÓDZTWO");
    assertThat(response.getBody()).doesNotContain("VOIVODESHIP");
  }

  @Test
  void testLocalizedEnContent() {
    ResponseEntity<String> response =
        restTemplate.getForEntity(baseUrl + "/en/voivodeships", String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).doesNotContain("WOJEWÓDZTWO");
    assertThat(response.getBody()).contains("VOIVODESHIP");
  }

  @Test
  void testGetVoivodeshipByCode() {
    var url = baseUrl + "/en/voivodeships/DS";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).contains("Miód wrzosowy z Borów Dolnośląskich");
    assertThat(response.getBody()).contains("Ogórki konserwowe ścinawskie");
    assertThat(response.getBody()).contains("Keselica / kysielnica / kysyłycia");
    assertThat(response.getBody()).contains("Wielokwiatowy miód z Doliny Baryczy");
    assertThat(response.getBody()).contains("Juha – kompot z suszonych owoców");
    assertThat(response.getBody()).contains("Wino śląskie");
  }

  @Test
  void testErrorHandling() {
    var url = baseUrl + "/en/voivodeships/NOT-A-VALUE";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).contains("There was an error...");
    assertThat(response.getBody()).contains(">Go to Homepage</a>");
  }

  @Test
  void testGetPoland() {
    var url = baseUrl + "/en/poland";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
  }
}
