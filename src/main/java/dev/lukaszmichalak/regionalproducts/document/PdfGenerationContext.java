package dev.lukaszmichalak.regionalproducts.document;

import lombok.Data;
import lombok.Setter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

@Data
final class PdfGenerationContext {

  private final PDDocument document;
  private final PDPageContentStream contentStream;
  private final PdfFonts fonts;
  private final PdfData data;

  @Setter private float lastElementY = PDRectangle.A4.getHeight();
}
