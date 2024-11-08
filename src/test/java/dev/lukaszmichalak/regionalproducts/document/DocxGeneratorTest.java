package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import org.junit.jupiter.api.Test;

class DocxGeneratorTest {

  private final DocumentGenerator docxGenerator = TestDocxGeneratorConfig.docxGenerator();

  @Test
  void createForVoivodeship() {
    docxGenerator.createForVoivodeship(new GetDocumentCommand("pl", "DS"));
  }
}
