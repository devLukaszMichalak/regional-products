package dev.lukaszmichalak.regionalproducts.locale;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

@ControllerAdvice
class LocaleControllerAdvice {
    
    @ModelAttribute
    public void addLang(Model model,
                        HttpServletRequest request,
                        @PathVariable(name = "lang", required = false) @Nullable String lang) {
        
        model.addAttribute("lang", Objects.requireNonNullElse(lang, "en"));
        
        model.addAttribute("currentPlUrl", request.getRequestURI().replace("/en/", "/pl/"));
        model.addAttribute("currentEnUrl", request.getRequestURI().replace("/pl/", "/en/"));
    }
    
}
