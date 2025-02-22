package dev.lukaszmichalak.regionalproducts.document;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetVoivodeshipDocumentCommand;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PdfGeneratorTest {

  private final DocumentGenerator pdfGenerator = TestDocumentGeneratorConfig.pdfGenerator();
  private final Tika tika = new Tika();

  private static final String EXPECTED_PDF_PATH_TEMPLATE = "src/test/resources/pdf/{lang}/DS.pdf";
  private static final boolean OVERRIDE_TEST_FILE = false;

  @ParameterizedTest
  @ValueSource(strings = {"pl", "en"})
  void createForVoivodeship(String lang) throws TikaException, IOException {

    byte[] pdf = pdfGenerator.createForVoivodeship(new GetVoivodeshipDocumentCommand(lang, "DS"));
    String pdfString = tika.parseToString(new ByteArrayInputStream(pdf));

    var expectedPdfPath = Path.of(EXPECTED_PDF_PATH_TEMPLATE.replace("{lang}", lang));

    if (OVERRIDE_TEST_FILE) {
      Files.write(expectedPdfPath, pdf);
    }

    byte[] expectedPdf = Files.readAllBytes(expectedPdfPath);
    String expectedPdfString = tika.parseToString(new ByteArrayInputStream(expectedPdf));

    assertThat(pdfString).isNotBlank();
    assertThat(pdfString).isEqualTo(expectedPdfString);
  }
}
