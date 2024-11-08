package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.document.DocumentGenerator;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{lang}/download")
class DocumentController {

  private final DocumentGenerator docxGenerator;
  private final DocumentGenerator pdfGenerator;

  DocumentController(
      @Qualifier("docxGenerator") DocumentGenerator docxGenerator,
      @Qualifier("pdfGenerator") DocumentGenerator pdfGenerator) {
    this.docxGenerator = docxGenerator;
    this.pdfGenerator = pdfGenerator;
  }

  @GetMapping("/docx/all")
  public String getDocx(@PathVariable("lang") String lang) {

    docxGenerator.createForAll(lang);
    return "all docx";
  }

  @GetMapping("/pdf/all")
  public String getPdf(@PathVariable("lang") String lang) {

    pdfGenerator.createForAll(lang);
    return "all pdf";
  }

  @GetMapping("/docx/voivodeship/{code}")
  public String getDocx(@ModelAttribute("cmd") GetDocumentCommand cmd) {

    docxGenerator.createForVoivodeship(cmd);
    return "docx";
  }

  @GetMapping("/pdf/voivodeship/{code}")
  public String getPdf(@ModelAttribute("cmd") GetDocumentCommand cmd) {

    pdfGenerator.createForVoivodeship(cmd);
    return "pdf";
  }
}
