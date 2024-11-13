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

class DocxGeneratorTest {

  private final DocumentGenerator docxGenerator = TestDocumentGeneratorConfig.docxGenerator();
  private final Tika tika = new Tika();

  private static final Path EXPECTED_DOCX_PATH = Path.of("src/test/resources/docx/DS.docx");
  private static final boolean OVERRIDE_TEST_FILE = false;

  @Test
  void createForVoivodeship() throws TikaException, IOException {

    byte[] docx = docxGenerator.createForVoivodeship(new GetDocumentCommand("pl", "DS"));
    String docxString = tika.parseToString(new ByteArrayInputStream(docx));

    if (OVERRIDE_TEST_FILE) {
      Files.write(EXPECTED_DOCX_PATH, docx);
    }

    byte[] expectedDocx = Files.readAllBytes(EXPECTED_DOCX_PATH);
    String expectedDocxString = tika.parseToString(new ByteArrayInputStream(expectedDocx));

    assertThat(docxString).isEqualTo(expectedDocxString);
  }
}
