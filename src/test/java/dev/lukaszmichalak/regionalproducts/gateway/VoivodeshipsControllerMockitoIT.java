package dev.lukaszmichalak.regionalproducts.gateway;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import dev.lukaszmichalak.regionalproducts.count.CountService;
import dev.lukaszmichalak.regionalproducts.count.CountStub;
import dev.lukaszmichalak.regionalproducts.locale.LocaleResolverTestConfig;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import java.util.List;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WithMockUser
@WebMvcTest(VoivodeshipsController.class)
@Import(LocaleResolverTestConfig.class)
@Execution(ExecutionMode.SAME_THREAD)
class VoivodeshipsControllerMockitoIT {

  @Autowired private MockMvc mockMvc;

  @MockitoBean private VoivodeshipService voivodeshipService;

  @MockitoBean private ProductService productService;

  @MockitoBean private CountService countService;

  @Test
  void testGetVoivodeships() throws Exception {
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    var voivodeshipDtosMatcher = IsIterableContainingInOrder.contains(VoivodeshipStub.ds());
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
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    mockMvc
        .perform(get("/pl/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(xpath("//span[contains(text(),'WOJEWÓDZTWO')]").exists())
        .andExpect(xpath("//span[contains(text(),'VOIVODESHIP')]").doesNotExist());
  }

  @Test
  void testLocalizedEnContent() throws Exception {
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(xpath("//span[contains(text(),'WOJEWÓDZTWO')]").doesNotExist())
        .andExpect(xpath("//span[contains(text(),'VOIVODESHIP')]").exists());
  }

  @Test
  void testVoivodeshipsLinksPl() throws Exception {
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    mockMvc
        .perform(get("/pl/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(
            xpath(
                    "//a[contains(@href, '/pl/voivodeships/%s')]"
                        .formatted(VoivodeshipStub.ds().code()))
                .exists())
        .andExpect(xpath("//a[contains(@href, '/pl/poland')]").exists());
  }

  @Test
  void testVoivodeshipsLinksEn() throws Exception {
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

    mockMvc
        .perform(get("/en/voivodeships"))
        .andExpect(status().isOk())
        .andExpect(
            xpath(
                    "//a[contains(@href, '/en/voivodeships/%s')]"
                        .formatted(VoivodeshipStub.ds().code()))
                .exists())
        .andExpect(xpath("//a[contains(@href, '/en/poland')]").exists());
  }

  @Test
  void testCountsConsistencyPl() throws Exception {
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

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
    doReturn(List.of(VoivodeshipStub.ds())).when(voivodeshipService).getVoivodeships();
    doReturn(List.of(CountStub.ds())).when(countService).getCounts();
    doReturn(CountStub.totalCount).when(countService).getTotalCount();

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
    doReturn(VoivodeshipStub.ds()).when(voivodeshipService).getVoivodeshipByCode("DS");

    mockMvc
        .perform(get("/en/voivodeships/DS"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("voivodeshipCode", "DS"))
        .andExpect(model().attributeExists("products"))
        .andExpect(view().name("voivodeship"));
  }

  @Test
  void testGetVoivodeshipByCodeLower() throws Exception {
    doReturn(VoivodeshipStub.ds()).when(voivodeshipService).getVoivodeshipByCode("ds");

    mockMvc
        .perform(get("/en/voivodeships/ds"))
        .andExpect(status().isOk())
        .andExpect(model().attribute("voivodeshipCode", "DS"))
        .andExpect(model().attributeExists("products"))
        .andExpect(view().name("voivodeship"));
  }

  @Test
  void testErrorHandling() throws Exception {
    doThrow(new RuntimeException("Service error")).when(voivodeshipService).getVoivodeships();

    mockMvc
        .perform(get("/en/voivodeships"))
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
}
