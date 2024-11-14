package dev.lukaszmichalak.regionalproducts.document;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DocxGeneratorTest {

  private final DocumentGenerator docxGenerator = TestDocumentGeneratorConfig.docxGenerator();
  private final Tika tika = new Tika();

  private static final String EXPECTED_DOCX_PATH_TEMPLATE =
      "src/test/resources/docx/{lang}/DS.docx";
  private static final boolean OVERRIDE_TEST_FILE = false;

  @ParameterizedTest
  @ValueSource(strings = {"pl", "en"})
  void createForVoivodeship(String lang) throws TikaException, IOException {

    byte[] docx = docxGenerator.createForVoivodeship(new GetDocumentCommand(lang, "DS"));
    String docxString = tika.parseToString(new ByteArrayInputStream(docx));

    var expectedDocxPath = Path.of(EXPECTED_DOCX_PATH_TEMPLATE.replace("{lang}", lang));

    if (OVERRIDE_TEST_FILE) {
      Files.write(expectedDocxPath, docx);
    }

    byte[] expectedDocx = Files.readAllBytes(expectedDocxPath);
    String expectedDocxString = tika.parseToString(new ByteArrayInputStream(expectedDocx));

    assertThat(docxString).isEqualTo(expectedDocxString);
  }
}
