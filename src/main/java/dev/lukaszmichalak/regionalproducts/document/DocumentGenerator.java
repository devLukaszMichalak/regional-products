package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;

public interface DocumentGenerator {
  byte[] createForVoivodeship(GetDocumentCommand cmd);

  byte[] createForAll(String lang);
}
