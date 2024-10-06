package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.count.CountService;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
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
    final ProductService productService;
    final CountService countService;
    
    @GetMapping("/voivodeships")
    public String getVoivodeships(Model model) {
        
        model.addAttribute("voivodeships", voivodeshipService.getVoivodeships());
        model.addAttribute("counts", countService.getCounts());
        model.addAttribute("totalCount", countService.getTotalCount());
        
        return "voivodeships";
    }
    
    @GetMapping("/voivodeships/{code}")
    public String getVoivodeship(Model model,
                                 @PathVariable("code") String code) {
        
        VoivodeshipDto voivodeship = voivodeshipService.getVoivodeshipByCode(code);
        
        model.addAttribute("products", productService.getProductsOfVoivodeship(voivodeship.id()));
        
        return "voivodeship";
    }
    
    @GetMapping("/poland")
    public String getPoland(Model model) {
        
        model.addAttribute("products", productService.getProducts());
        
        return "voivodeship";
    }
}
