package dev.lukaszmichalak.regionalproducts.gateway.command;

import dev.lukaszmichalak.regionalproducts.validation.ValidLanguage;
import jakarta.validation.constraints.NotNull;

public record GetPolandDocumentCommand(@NotNull @ValidLanguage String lang) {}
