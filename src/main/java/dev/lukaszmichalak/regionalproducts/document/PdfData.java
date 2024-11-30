package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import java.util.List;

record PdfData(
    String name,
    List<ProductDto> products,
    boolean isPl,
    String descriptionPl,
    String descriptionEn) {

  String langDescription() {
    return isPl ? descriptionPl : descriptionEn;
  }

  String langColumnTitleName() {
    return isPl ? "Nazwa" : "Name";
  }

  String langColumnTitleType() {
    return isPl ? "Typ" : "Type";
  }

  String langColumnTitleDateOfEntry() {
    return isPl ? "Data wprowadzenia" : "Date of entry";
  }
}
