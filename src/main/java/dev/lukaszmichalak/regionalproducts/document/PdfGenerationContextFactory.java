package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.document.exception.PdfContextCreationException;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.stereotype.Component;

@Component
class PdfGenerationContextFactory {

  private final ProductService productService;
  private final VoivodeshipService voivodeshipService;
  private final PolandDescriptionService polandDescriptionService;

  private final byte[] NEUTRAL_SANS_REGULAR;
  private final byte[] NEUTRAL_SANS_BOLD;

  public PdfGenerationContextFactory(
      ProductService productService,
      VoivodeshipService voivodeshipService,
      PolandDescriptionService polandDescriptionService) {
    this.productService = productService;
    this.voivodeshipService = voivodeshipService;
    this.polandDescriptionService = polandDescriptionService;

    try (var boldFont =
            PdfGenerationContextFactory.class.getResourceAsStream(
                "/static/fonts/NeutralSans-Bold.ttf");
        var regularFont =
            PdfGenerationContextFactory.class.getResourceAsStream(
                "/static/fonts/NeutralSans-Regular.ttf")) {

      if (boldFont == null) {
        throw new PdfContextCreationException("Failed to load PDF fonts! Bold font is null!");
      }

      if (regularFont == null) {
        throw new PdfContextCreationException("Failed to load PDF fonts! Regular font is null!");
      }

      NEUTRAL_SANS_BOLD = boldFont.readAllBytes();
      NEUTRAL_SANS_REGULAR = regularFont.readAllBytes();

    } catch (IOException e) {
      throw new PdfContextCreationException(e);
    }
  }

  PdfGenerationContext forVoivodeship(PDDocument document, GetDocumentCommand cmd)
      throws IOException {

    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    boolean isPl = "pl".equals(cmd.lang());

    VoivodeshipDto voivodeship = voivodeshipService.getVoivodeshipByCode(cmd.code());
    List<ProductDto> products = productService.getProductsOfVoivodeship(voivodeship.id());

    PDType0Font fontBold = PDType0Font.load(document, new ByteArrayInputStream(NEUTRAL_SANS_BOLD));
    PDType0Font fontRegular =
        PDType0Font.load(document, new ByteArrayInputStream(NEUTRAL_SANS_REGULAR));

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

    PDType0Font fontBold = PDType0Font.load(document, new ByteArrayInputStream(NEUTRAL_SANS_BOLD));
    PDType0Font fontRegular =
        PDType0Font.load(document, new ByteArrayInputStream(NEUTRAL_SANS_REGULAR));

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
