package dev.lukaszmichalak.regionalproducts.gateway.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GetVoivodeshipDocumentCommand(
    @NotNull @Pattern(regexp = "^(?:pl|en)$") String lang,
    @NotNull @Pattern(regexp = "^[A-Z]{2}$") String code) {}
