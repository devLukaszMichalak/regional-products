package dev.lukaszmichalak.regionalproducts.document;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.api.Test;

class PdfGeneratorTest {

  private final DocumentGenerator pdfGenerator = TestDocumentGeneratorConfig.pdfGenerator();
  private final Tika tika = new Tika();

  private static final Path EXPECTED_PDF_PATH = Path.of("src/test/resources/pdf/DS.pdf");
  private static final boolean OVERRIDE_TEST_FILE = false;

  @Test
  void createForVoivodeship() throws TikaException, IOException {

    byte[] pdf = pdfGenerator.createForVoivodeship(new GetDocumentCommand("pl", "DS"));
    String pdfString = tika.parseToString(new ByteArrayInputStream(pdf));

    if (OVERRIDE_TEST_FILE) {
      Files.write(EXPECTED_PDF_PATH, pdf);
    }

    byte[] expectedPdf = Files.readAllBytes(EXPECTED_PDF_PATH);
    String expectedPdfString = tika.parseToString(new ByteArrayInputStream(expectedPdf));

    assertThat(pdfString).isEqualTo(expectedPdfString);
  }
}
