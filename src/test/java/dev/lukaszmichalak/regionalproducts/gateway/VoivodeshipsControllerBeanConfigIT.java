package dev.lukaszmichalak.regionalproducts.gateway;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.lukaszmichalak.regionalproducts.count.CountService;
import dev.lukaszmichalak.regionalproducts.count.CountStub;
import dev.lukaszmichalak.regionalproducts.count.TestCountConfig;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.TestProductConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.TestVoivodeshipConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WithMockUser
@WebMvcTest(VoivodeshipsController.class)
@Import(VoivodeshipsControllerBeanConfigIT.TestVoivodeshipControllerConfig.class)
class VoivodeshipsControllerBeanConfigIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void testGetVoivodeships() throws Exception {

    var voivodeshipDtosMatcher = IsIterableContainingInOrder.contains(VoivodeshipStub.dsDto());
    var countDtosMatcher = IsIterableContainingInOrder.contains(CountStub.ds());

    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("voivodeships", "counts", "totalCount"))
        .andExpect(model().attribute("voivodeships", voivodeshipDtosMatcher))
        .andExpect(model().attribute("counts", countDtosMatcher))
        .andExpect(model().attribute("totalCount", CountStub.totalCount))
        .andExpect(view().name("voivodeships"));
  }

  @Test
  void testLocalizedPlContent() throws Exception {
    mockMvc
        .perform(get("/pl/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(xpath("//span[contains(text(),'WOJEWÓDZTWO')]").exists())
        .andExpect(xpath("//span[contains(text(),'VOIVODESHIP')]").doesNotExist());
  }

  @Test
  void testLocalizedEnContent() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(xpath("//span[contains(text(),'WOJEWÓDZTWO')]").doesNotExist())
        .andExpect(xpath("//span[contains(text(),'VOIVODESHIP')]").exists());
  }

  @Test
  void testVoivodeshipsLinksPl() throws Exception {
    mockMvc
        .perform(get("/pl/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(
            xpath(
                    "//a[contains(@href, '/pl/voivodeships/%s')]"
                        .formatted(VoivodeshipStub.dsDto().code()))
                .exists())
        .andExpect(xpath("//a[contains(@href, '/pl/poland')]").exists());
  }

  @Test
  void testVoivodeshipsLinksEn() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(
            xpath(
                    "//a[contains(@href, '/en/voivodeships/%s')]"
                        .formatted(VoivodeshipStub.dsDto().code()))
                .exists())
        .andExpect(xpath("//a[contains(@href, '/en/poland')]").exists());
  }

  @Test
  void testCountsConsistencyPl() throws Exception {
    mockMvc
        .perform(get("/pl/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("totalCount", CountStub.totalCount))
        .andExpect(
            xpath("//td[@class='py-1 fw-bolder border-start']")
                .string(Long.toString(CountStub.totalCount)));
  }

  @Test
  void testCountsConsistencyEn() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("totalCount", CountStub.totalCount))
        .andExpect(
            xpath("//td[@class='py-1 fw-bolder border-start']")
                .string(Long.toString(CountStub.totalCount)));
  }

  @Test
  void testGetVoivodeshipByCode() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships/DS"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("voivodeshipCode", "DS"))
        .andExpect(model().attributeExists("products"))
        .andExpect(view().name("voivodeship"));
  }

  @Test
  void testGetVoivodeshipByCodeLower() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships/ds"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("voivodeshipCode", "DS"))
        .andExpect(model().attributeExists("products"))
        .andExpect(view().name("voivodeship"));
  }

  @Test
  void testErrorHandling() throws Exception {
    mockMvc
        .perform(get("/en/voivodeships/NOT-A-VALUE"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/en/error"));
  }

  @Test
  void testGetPoland() throws Exception {
    mockMvc
        .perform(get("/en/poland"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("voivodeshipCode", (Object) null))
        .andExpect(model().attributeExists("products"))
        .andExpect(view().name("voivodeship"));
  }

  @TestConfiguration
  static class TestVoivodeshipControllerConfig {

    @Bean("productService")
    ProductService productService() {
      return TestProductConfig.productService();
    }

    @Bean("voivodeshipService")
    VoivodeshipService voivodeshipService() {
      return TestVoivodeshipConfig.voivodeshipService();
    }

    @Bean("countService")
    CountService countService() {
      return TestCountConfig.countService();
    }
  }
}
