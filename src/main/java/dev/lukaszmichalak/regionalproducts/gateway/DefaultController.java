package dev.lukaszmichalak.regionalproducts.gateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class DefaultController {
    
    @GetMapping()
    public String getDefault() {
        return "redirect:/en/voivodeships";
    }
}
