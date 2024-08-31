package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
class MainController {
    
    final VoivodeshipService voivodeshipService;
    
    @GetMapping
    public String getDefault() {
        return "redirect:/dashboard";
    }
    
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("voivodeships", voivodeshipService.getVoivodeships());
        return "dashboard";
    }
}
