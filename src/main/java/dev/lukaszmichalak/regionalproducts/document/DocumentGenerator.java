package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetPolandDocumentCommand;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetVoivodeshipDocumentCommand;

public interface DocumentGenerator {
  byte[] createForVoivodeship(GetVoivodeshipDocumentCommand cmd);

  byte[] createForAll(GetPolandDocumentCommand lang);
}
