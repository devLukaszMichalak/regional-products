package dev.lukaszmichalak.regionalproducts.document;

import static org.vandeseer.easytable.settings.HorizontalAlignment.*;

import dev.lukaszmichalak.regionalproducts.document.exception.DocumentGenerationException;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetPolandDocumentCommand;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetVoivodeshipDocumentCommand;
import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.stereotype.Component;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

@Component("pdfGenerator")
@RequiredArgsConstructor
class PdfGenerator implements DocumentGenerator {

  private final PdfGenerationContextFactory pdfGenerationContextFactory;

  @Override
  public byte[] createForVoivodeship(GetVoivodeshipDocumentCommand cmd) {

    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PDDocument document = new PDDocument()) {

      PdfGenerationContext pdfGenerationContext =
          pdfGenerationContextFactory.forVoivodeship(document, cmd);

      return generatePdf(pdfGenerationContext, outputStream);

    } catch (IOException e) {
      throw new DocumentGenerationException(e);
    }
  }

  @Override
  public byte[] createForAll(GetPolandDocumentCommand cmd) {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PDDocument document = new PDDocument()) {

      PdfGenerationContext pdfGenerationContext =
          pdfGenerationContextFactory.forAll(document, cmd.lang());

      return generatePdf(pdfGenerationContext, outputStream);

    } catch (IOException e) {
      throw new DocumentGenerationException(e);
    }
  }

  private byte[] generatePdf(
      PdfGenerationContext pdfGenerationContext, ByteArrayOutputStream outputStream)
      throws IOException {
    addTitle(pdfGenerationContext);
    addDescription(pdfGenerationContext);
    addTable(pdfGenerationContext);

    pdfGenerationContext.getContentStream().close();
    pdfGenerationContext.getDocument().save(outputStream);
    return outputStream.toByteArray();
  }

  private void addTitle(PdfGenerationContext pdfGenerationContext) throws IOException {

    String title = pdfGenerationContext.getData().name().toUpperCase();
    int titleFontSize = 20;
    float titleY = pdfGenerationContext.getLastElementY() - 100;
    float titleWidth =
        pdfGenerationContext.getFonts().fontBold().getStringWidth(title) / 1000 * titleFontSize;
    float titleX = (PDRectangle.A4.getWidth() - titleWidth) / 2;

    PDPageContentStream contentStream = pdfGenerationContext.getContentStream();
    contentStream.setFont(pdfGenerationContext.getFonts().fontBold(), 20);
    contentStream.beginText();
    contentStream.newLineAtOffset(titleX, titleY);
    contentStream.showText(title);
    contentStream.endText();

    pdfGenerationContext.setLastElementY(titleY - 30);
  }

  private void addDescription(PdfGenerationContext pdfGenerationContext) throws IOException {

    PDPageContentStream contentStream = pdfGenerationContext.getContentStream();

    int descriptionFontSize = 12;

    contentStream.setFont(pdfGenerationContext.getFonts().fontRegular(), descriptionFontSize);
    contentStream.beginText();

    float maxWidth = 170 + 170 + 75 + 75;
    float descriptionX = (PDRectangle.A4.getWidth() - maxWidth) / 2;
    contentStream.newLineAtOffset(descriptionX, pdfGenerationContext.getLastElementY());

    float lineSpacing = 20;

    float currentY = pdfGenerationContext.getLastElementY();

    for (String line :
        wrapText(
            pdfGenerationContext.getData().langDescription(),
            pdfGenerationContext.getFonts().fontRegular(),
            maxWidth,
            descriptionFontSize)) {
      contentStream.showText(line);
      contentStream.newLineAtOffset(0, -lineSpacing);
      currentY -= lineSpacing;
    }
    contentStream.endText();

    pdfGenerationContext.setLastElementY(currentY);
  }

  private List<String> wrapText(String text, PDType0Font font, float maxWidth, int fontSize)
      throws IOException {
    List<String> lines = new ArrayList<>();
    String[] words = text.split(" ");
    StringBuilder line = new StringBuilder();

    for (String word : words) {
      String testLine = line + (line.isEmpty() ? "" : " ") + word;
      if (font.getStringWidth(testLine) / 1000 * fontSize > maxWidth) {
        lines.add(line.toString());
        line = new StringBuilder(word);
      } else {
        line.append(line.isEmpty() ? "" : " ").append(word);
      }
    }
    lines.add(line.toString());
    return lines;
  }

  private void addTable(PdfGenerationContext pdfGenerationContext) {
    final Table.TableBuilder tableBuilder =
        Table.builder()
            .borderWidth(1)
            .borderColor(Color.BLACK)
            .addColumnsOfWidth(170, 170, 75, 75)
            .horizontalAlignment(LEFT)
            .fontSize(11)
            .font(pdfGenerationContext.getFonts().fontRegular())
            .borderColor(Color.BLACK);

    addHeaderRow(pdfGenerationContext, tableBuilder);

    for (ProductDto product : pdfGenerationContext.getData().products()) {
      addDataRow(product, tableBuilder);
    }

    TableDrawer tableDrawer =
        TableDrawer.builder()
            .contentStream(pdfGenerationContext.getContentStream())
            .table(tableBuilder.build())
            .startX((PDRectangle.A4.getWidth() - (170 + 170 + 75 + 75)) / 2)
            .startY(PDRectangle.A4.getWidth())
            .endY(50)
            .build();

    try {
      tableDrawer.draw(pdfGenerationContext::getDocument, () -> new PDPage(PDRectangle.A4), 50);
    } catch (IOException e) {
      throw new DocumentGenerationException(e);
    }
  }

  private void addHeaderRow(
      PdfGenerationContext pdfGenerationContext, Table.TableBuilder tableBuilder) {
    tableBuilder.addRow(
        Row.builder()
            .add(
                TextCell.builder()
                    .text(pdfGenerationContext.getData().langColumnTitleName())
                    .build())
            .add(
                TextCell.builder()
                    .text(pdfGenerationContext.getData().langColumnTitleType())
                    .build())
            .add(
                TextCell.builder()
                    .text(pdfGenerationContext.getData().langColumnTitleDateOfEntry())
                    .build())
            .add(
                TextCell.builder()
                    .text(pdfGenerationContext.getData().langColumnAverageRating())
                    .build())
            .textColor(Color.BLACK)
            .font(pdfGenerationContext.getFonts().fontRegular())
            .build());
  }

  private void addDataRow(ProductDto product, Table.TableBuilder tableBuilder) {
    tableBuilder.addRow(
        Row.builder()
            .add(TextCell.builder().text(product.name()).build())
            .add(TextCell.builder().text(product.productTypeName()).build())
            .add(TextCell.builder().text(product.dateOfEntry().toString()).build())
            .add(TextCell.builder().text(product.averageRating().toString()).build())
            .build());
  }
}
