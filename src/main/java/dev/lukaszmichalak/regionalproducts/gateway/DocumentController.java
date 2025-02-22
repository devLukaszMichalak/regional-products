package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.document.DocumentGenerator;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetPolandDocumentCommand;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetVoivodeshipDocumentCommand;
import jakarta.validation.Valid;
import java.time.Clock;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{lang}/download")
class DocumentController {

  private final DocumentGenerator docxGenerator;
  private final DocumentGenerator pdfGenerator;
  private final Clock clock;

  DocumentController(
      @Qualifier("docxGenerator") DocumentGenerator docxGenerator,
      @Qualifier("pdfGenerator") DocumentGenerator pdfGenerator,
      Clock clock) {
    this.docxGenerator = docxGenerator;
    this.pdfGenerator = pdfGenerator;
    this.clock = clock;
  }

  @GetMapping("/docx/all")
  public ResponseEntity<byte[]> getDocx(
      @Valid @ModelAttribute("cmd") GetPolandDocumentCommand cmd) {
    byte[] documentBytes = docxGenerator.createForAll(cmd);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_DOCX);

    var filename = "PL-" + LocalDateTime.now(clock) + ".docx";
    headers.setContentDisposition(ContentDisposition.formData().filename(filename).build());

    return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
  }

  @GetMapping("/pdf/all")
  public ResponseEntity<byte[]> getPdf(@Valid @ModelAttribute("cmd") GetPolandDocumentCommand cmd) {
    byte[] documentBytes = pdfGenerator.createForAll(cmd);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);

    var filename = "PL-" + LocalDateTime.now(clock) + ".pdf";
    headers.setContentDisposition(ContentDisposition.formData().filename(filename).build());

    return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
  }

  @GetMapping("/docx/voivodeship/{code}")
  public ResponseEntity<byte[]> getDocx(
      @Valid @ModelAttribute("cmd") GetVoivodeshipDocumentCommand cmd) {
    byte[] documentBytes = docxGenerator.createForVoivodeship(cmd);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_DOCX);

    var filename = cmd.code() + "-" + LocalDateTime.now(clock) + ".docx";
    headers.setContentDisposition(ContentDisposition.formData().filename(filename).build());

    return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
  }

  @GetMapping("/pdf/voivodeship/{code}")
  public ResponseEntity<byte[]> getPdf(
      @Valid @ModelAttribute("cmd") GetVoivodeshipDocumentCommand cmd) {
    byte[] documentBytes = pdfGenerator.createForVoivodeship(cmd);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);

    var filename = cmd.code() + "-" + LocalDateTime.now(clock) + ".pdf";
    headers.setContentDisposition(ContentDisposition.formData().filename(filename).build());

    return new ResponseEntity<>(documentBytes, headers, HttpStatus.OK);
  }

  private static final class MediaType extends org.springframework.http.MediaType {

    private static final org.springframework.http.MediaType APPLICATION_DOCX =
        MediaType.valueOf(
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

    public MediaType(String type) {
      super(type);
    }
  }
}
