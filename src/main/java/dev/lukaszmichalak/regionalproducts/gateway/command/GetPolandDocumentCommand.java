package dev.lukaszmichalak.regionalproducts.gateway.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GetPolandDocumentCommand(@NotNull @Pattern(regexp = "^(?:pl|en)$") String lang) {}
