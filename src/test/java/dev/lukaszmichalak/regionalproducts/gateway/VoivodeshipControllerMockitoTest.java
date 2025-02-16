package dev.lukaszmichalak.regionalproducts.gateway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import dev.lukaszmichalak.regionalproducts.count.CountService;
import dev.lukaszmichalak.regionalproducts.count.CountStub;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.ProductStub;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class VoivodeshipControllerMockitoTest {

  @Mock private VoivodeshipService voivodeshipService;

  @Mock private ProductService productService;

  @Mock private CountService countService;

  @Mock private Model model;

  @InjectMocks private VoivodeshipsController voivodeshipsController;

  @Test
  void testGetVoivodeships() {

    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    String returnValue = voivodeshipsController.getVoivodeships(model);

    assertThat(returnValue).isEqualTo("voivodeships");
    verify(voivodeshipService).getVoivodeships();
    verify(countService).getCounts();
    verify(countService).getTotalCount();
    verify(model).addAttribute("voivodeships", voivodeshipService.getVoivodeships());
    verify(model).addAttribute("counts", countService.getCounts());
    verify(model).addAttribute("totalCount", countService.getTotalCount());
  }

  @Test
  void testGetVoivodeship() {

    doReturn(VoivodeshipStub.ds())
        .when(voivodeshipService)
        .getVoivodeshipByCode(VoivodeshipStub.ds().code());
    var products = List.of(ProductStub.honeyDto(), ProductStub.wineDto());
    doReturn(products).when(productService).getProductsOfVoivodeship(VoivodeshipStub.ds().id());

    String returnValue = voivodeshipsController.getVoivodeship(model, VoivodeshipStub.ds().code());

    assertThat(returnValue).isEqualTo("voivodeship");
    verify(voivodeshipService).getVoivodeshipByCode(VoivodeshipStub.ds().code());
    verify(productService).getProductsOfVoivodeship(VoivodeshipStub.ds().id());
    verify(model).addAttribute("voivodeshipCode", VoivodeshipStub.ds().code());
    verify(model).addAttribute("products", products);
  }

  @Test
  void testGetPoland() {

    var products = List.of(ProductStub.honeyDto(), ProductStub.wineDto());
    doReturn(products).when(productService).getProducts();

    String returnValue = voivodeshipsController.getPoland(model);

    assertThat(returnValue).isEqualTo("voivodeship");
    verify(voivodeshipService, never()).getVoivodeshipByCode(any());
    verify(productService).getProducts();
    verify(model).addAttribute("voivodeshipCode", null);
    verify(model).addAttribute("products", products);
  }
}
