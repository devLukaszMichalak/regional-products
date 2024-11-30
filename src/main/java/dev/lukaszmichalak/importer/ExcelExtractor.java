package dev.lukaszmichalak.importer;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

@RequiredArgsConstructor
class ExcelExtractor {

  private final Sheet sheet;

  Set<ExcelProduct> extract() {
    return StreamSupport.stream(sheet.spliterator(), false)
        .filter(row -> !isHeader(row))
        .map(this::getExcelProduct)
        .collect(Collectors.toSet());
  }

  private boolean isHeader(Row row) {
    return row.getRowNum() == 0;
  }

  private ExcelProduct getExcelProduct(Row row) {
    String voivodeship = row.getCell(0).getStringCellValue().strip();
    String productType = row.getCell(1).getStringCellValue().strip();
    String productName = row.getCell(2).getStringCellValue().strip();
    LocalDate dateOfEntry = row.getCell(3).getLocalDateTimeCellValue().toLocalDate();

    return new ExcelProduct(voivodeship, productType, productName, dateOfEntry);
  }
}
