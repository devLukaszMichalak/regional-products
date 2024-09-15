package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.count.CountService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}")
@RequiredArgsConstructor
class VoivodeshipsController {
    
    final VoivodeshipService voivodeshipService;
    final CountService countService;
    
    @GetMapping("/voivodeships")
    public String getVoivodeships(Model model) {
        
        model.addAttribute("voivodeships", voivodeshipService.getVoivodeships());
        model.addAttribute("counts", countService.getCounts());
        
        return "voivodeships";
    }
    
    @GetMapping("/voivodeships/{code}")
    public String getVoivodeship(Model model,
                                 @PathVariable("code") String code) {
        
        return "voivodeship";
    }
}
