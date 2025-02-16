package dev.lukaszmichalak.regionalproducts.gateway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class VoivodeshipControllerRestClientIT {

  @LocalServerPort private int port;

  private RestClient restClient;

  @BeforeEach
  public void setUp() {
    restClient = RestClient.builder().baseUrl("http://localhost:" + port).build();
  }

  @Test
  void testGetVoivodeships() {
    ResponseEntity<String> response =
        this.restClient.get().uri("/en/voivodeships").retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).isEqualToIgnoringNewLines(ResponseStub.en_voivodeships);
  }

  @Test
  void testLocalizedPlContent() {
    ResponseEntity<String> response =
        this.restClient.get().uri("/pl/voivodeships").retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).contains("WOJEWÓDZTWO");
    assertThat(response.getBody()).doesNotContain("VOIVODESHIP");
  }

  @Test
  void testLocalizedEnContent() {
    ResponseEntity<String> response =
        this.restClient.get().uri("/en/voivodeships").retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).doesNotContain("WOJEWÓDZTWO");
    assertThat(response.getBody()).contains("VOIVODESHIP");
  }

  @Test
  void testGetVoivodeshipByCode() {
    ResponseEntity<String> response =
        this.restClient.get().uri("/en/voivodeships/DS").retrieve().toEntity(String.class);

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
    var uri = "/en/voivodeships/NOT-A-VALUE";
    ResponseEntity<String> response =
        this.restClient.get().uri(uri).retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is3xxRedirection()).isTrue();
    assertThat(response.getHeaders().getLocation()).isNotNull();
    assertThat(response.getHeaders().getLocation().toString()).endsWith("en/error");
  }

  @Test
  void testError() {
    var uri = "/en/error";
    ResponseEntity<String> response =
        this.restClient.get().uri(uri).retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    assertThat(response.getBody()).isNotNull();
    assertThat(response.getBody()).contains("There was an error...");
    assertThat(response.getBody()).contains(">Go to Homepage</a>");
  }

  @Test
  void testGetPoland() {
    ResponseEntity<String> response =
        this.restClient.get().uri("/en/poland").retrieve().toEntity(String.class);

    assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
  }
}
