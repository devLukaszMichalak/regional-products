package dev.lukaszmichalak.importer;

import java.time.LocalDate;

record ExcelProduct(
    String voivodeship, String productType, String productName, LocalDate dateOfEntry) {}
