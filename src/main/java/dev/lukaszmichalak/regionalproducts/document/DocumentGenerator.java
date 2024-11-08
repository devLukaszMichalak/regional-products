package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;

public interface DocumentGenerator {
  void createForVoivodeship(GetDocumentCommand cmd);

  void createForAll(String lang);
}
