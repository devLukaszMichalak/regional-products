package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.document.exception.DocumentGenerationException;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetPolandDocumentCommand;
import dev.lukaszmichalak.regionalproducts.gateway.command.GetVoivodeshipDocumentCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.io.ByteArrayOutputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Component;

@Component("docxGenerator")
@RequiredArgsConstructor
class DocxGenerator implements DocumentGenerator {

  private final ProductService productService;
  private final VoivodeshipService voivodeshipService;
  private final PolandDescriptionService polandDescriptionService;

  @Override
  public byte[] createForVoivodeship(GetVoivodeshipDocumentCommand cmd) {

    VoivodeshipDto voivodeship = voivodeshipService.getVoivodeshipByCode(cmd.code());
    List<ProductDto> products = productService.getProductsOfVoivodeship(voivodeship.id());

    try (XWPFDocument document = new XWPFDocument();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

      addTitle(document, voivodeship.name());
      addDescription(
          document, isPL(cmd.lang()) ? voivodeship.descriptionPl() : voivodeship.descriptionEn());
      addProductTable(document, products, cmd.lang());

      document.write(outputStream);
      return outputStream.toByteArray();

    } catch (Exception e) {
      throw new DocumentGenerationException(e);
    }
  }

  @Override
  public byte[] createForAll(GetPolandDocumentCommand cmd) {

    List<ProductDto> products = productService.getProducts();

    try (XWPFDocument document = new XWPFDocument();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

      addTitle(document, isPL(cmd.lang()) ? "Polska" : "Poland");
      addDescription(
          document,
          isPL(cmd.lang()) ? polandDescriptionService.getPl() : polandDescriptionService.getEn());
      addProductTable(document, products, cmd.lang());

      document.write(outputStream);
      return outputStream.toByteArray();

    } catch (Exception e) {
      throw new DocumentGenerationException(e);
    }
  }

  private void addTitle(XWPFDocument document, String name) {
    XWPFParagraph titleParagraph = document.createParagraph();
    titleParagraph.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun titleRun = titleParagraph.createRun();
    titleRun.setText(name.toUpperCase());
    titleRun.setBold(true);
    titleRun.setFontSize(20);
  }

  private void addDescription(XWPFDocument document, String description) {
    XWPFParagraph descriptionParagraph = document.createParagraph();
    descriptionParagraph.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun descriptionRun = descriptionParagraph.createRun();
    descriptionRun.setText(description);
    descriptionRun.setFontSize(12);
  }

  private void addProductTable(XWPFDocument document, List<ProductDto> products, String lang) {
    XWPFTable table = document.createTable();
    addHeaderRow(table, lang);

    for (ProductDto product : products) {
      addProductRow(table, product);
    }
  }

  private void addHeaderRow(XWPFTable table, String lang) {
    XWPFTableRow headerRow = table.getRow(0);
    headerRow.createCell();
    headerRow.createCell();
    headerRow.createCell();
    headerRow.getCell(0).setText(isPL(lang) ? "Nazwa" : "Name");
    headerRow.getCell(1).setText(isPL(lang) ? "Typ" : "Type");
    headerRow.getCell(2).setText(isPL(lang) ? "Data wprowadzenia" : "Date of entry");
    headerRow.getCell(3).setText(isPL(lang) ? "Średnia ocena" : "Average rating");
  }

  private void addProductRow(XWPFTable table, ProductDto product) {
    XWPFTableRow row = table.createRow();
    row.getCell(0).setText(product.name());
    row.getCell(1).setText(product.productTypeName());
    row.getCell(2).setText(product.dateOfEntry().toString());
    row.getCell(3).setText(product.averageRating().toString());
  }

  private boolean isPL(String lang) {
    return "pl".equals(lang);
  }
}
