package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PdfGenerationContextFactory {

  private final ProductService productService;
  private final VoivodeshipService voivodeshipService;
  private final PolandDescriptionService polandDescriptionService;

  private static final InputStream NEUTRAL_SANS_REGULAR =
      PdfGenerator.class.getResourceAsStream("/static/fonts/NeutralSans-Regular.ttf");
  private static final InputStream NEUTRAL_SANS_BOLD =
      PdfGenerator.class.getResourceAsStream("/static/fonts/NeutralSans-Bold.ttf");

  PdfGenerationContext forVoivodeship(PDDocument document, GetDocumentCommand cmd)
      throws IOException {

    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    boolean isPl = "pl".equals(cmd.lang());

    VoivodeshipDto voivodeship = voivodeshipService.getVoivodeshipByCode(cmd.code());
    List<ProductDto> products = productService.getProductsOfVoivodeship(voivodeship.id());

    PDType0Font fontBold = PDType0Font.load(document, NEUTRAL_SANS_BOLD);
    PDType0Font fontRegular = PDType0Font.load(document, NEUTRAL_SANS_REGULAR);

    return new PdfGenerationContext(
        document,
        contentStream,
        new PdfFonts(fontRegular, fontBold),
        new PdfData(
            voivodeship.name(),
            products,
            isPl,
            voivodeship.descriptionPl(),
            voivodeship.descriptionEn()));
  }

  PdfGenerationContext forAll(PDDocument document, String lang) throws IOException {

    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    boolean isPl = "pl".equals(lang);

    List<ProductDto> products = productService.getProducts();

    PDType0Font fontBold = PDType0Font.load(document, NEUTRAL_SANS_BOLD);
    PDType0Font fontRegular = PDType0Font.load(document, NEUTRAL_SANS_REGULAR);

    return new PdfGenerationContext(
        document,
        contentStream,
        new PdfFonts(fontRegular, fontBold),
        new PdfData(
            isPl ? "Polska" : "Poland",
            products,
            isPl,
            polandDescriptionService.getPl(),
            polandDescriptionService.getEn()));
  }
}
