package dev.lukaszmichalak.regionalproducts.gateway.command;

import dev.lukaszmichalak.regionalproducts.validation.ValidLanguage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GetVoivodeshipDocumentCommand(
    @NotNull @ValidLanguage String lang, @NotNull @Pattern(regexp = "^[A-Z]{2}$") String code) {}
