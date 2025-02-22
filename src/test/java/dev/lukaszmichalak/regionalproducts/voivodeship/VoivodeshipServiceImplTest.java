package dev.lukaszmichalak.regionalproducts.voivodeship;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.exception.VoivodeshipNotFoundException;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VoivodeshipServiceImplTest {

  @Mock private VoivodeshipRepository voivodeshipRepository;

  @InjectMocks private VoivodeshipServiceImpl voivodeshipService;

  @BeforeEach
  void setUp() {
    lenient().when(voivodeshipRepository.count()).thenReturn(1L);
    voivodeshipService.init();
  }

  @Test
  void shouldReturnAllVoivodeships() {
    when(voivodeshipRepository.findAll()).thenReturn(List.of(VoivodeshipStub.ds()));

    List<VoivodeshipDto> result = voivodeshipService.getVoivodeships();

    assertThat(result).isNotNull();
    assertThat(result).hasSize(1);
    assertThat(result.getFirst()).isEqualTo(VoivodeshipStub.dsDto());
  }

  @Test
  void shouldReturnAllVoivodeshipsFromCache() {
    when(voivodeshipRepository.findAll()).thenReturn(List.of(VoivodeshipStub.ds()));

    List<VoivodeshipDto> results1 = voivodeshipService.getVoivodeships();
    List<VoivodeshipDto> results2 = voivodeshipService.getVoivodeships();

    assertThat(results1).isNotNull();
    assertThat(results1).hasSize(1);
    assertThat(results1.getFirst()).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(results2).isNotNull();
    assertThat(results2).hasSize(1);
    assertThat(results2.getFirst()).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(results1).containsExactlyElementsOf(results2);
    verify(voivodeshipRepository, times(1)).findAll();
  }

  @Test
  void shouldReturnVoivodeshipById() {
    when(voivodeshipRepository.findById(anyLong())).thenReturn(Optional.of(VoivodeshipStub.ds()));

    VoivodeshipDto result = voivodeshipService.getVoivodeshipById(1L);

    assertThat(result).isNotNull();
    assertThat(result).isEqualTo(VoivodeshipStub.dsDto());
  }

  @Test
  void shouldReturnVoivodeshipByIdFromCache() {
    when(voivodeshipRepository.findById(anyLong())).thenReturn(Optional.of(VoivodeshipStub.ds()));

    VoivodeshipDto result1 = voivodeshipService.getVoivodeshipById(1L);
    VoivodeshipDto result2 = voivodeshipService.getVoivodeshipById(1L);

    assertThat(result1).isNotNull();
    assertThat(result1).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(result2).isNotNull();
    assertThat(result2).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(result1).isEqualTo(result2);
    verify(voivodeshipRepository, times(1)).findById(anyLong());
  }

  @Test
  void shouldThrowExceptionWhenVoivodeshipNotFoundById() {
    when(voivodeshipRepository.findById(anyLong())).thenReturn(Optional.empty());

    assertThatThrownBy(() -> voivodeshipService.getVoivodeshipById(99L))
        .isExactlyInstanceOf(VoivodeshipNotFoundException.class);
  }

  @Test
  void shouldReturnVoivodeshipByCode() {
    when(voivodeshipRepository.findByCodeIgnoreCase(anyString()))
        .thenReturn(Optional.of(VoivodeshipStub.ds()));

    VoivodeshipDto result = voivodeshipService.getVoivodeshipByCode(VoivodeshipStub.ds().getCode());

    assertThat(result).isNotNull();
    assertThat(result).isEqualTo(VoivodeshipStub.dsDto());
  }

  @Test
  void shouldReturnVoivodeshipByCodeFromCache() {
    when(voivodeshipRepository.findByCodeIgnoreCase(anyString()))
        .thenReturn(Optional.of(VoivodeshipStub.ds()));

    VoivodeshipDto result1 =
        voivodeshipService.getVoivodeshipByCode(VoivodeshipStub.ds().getCode());
    VoivodeshipDto result2 =
        voivodeshipService.getVoivodeshipByCode(VoivodeshipStub.ds().getCode());

    assertThat(result1).isNotNull();
    assertThat(result1).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(result2).isNotNull();
    assertThat(result2).isEqualTo(VoivodeshipStub.dsDto());
    assertThat(result1).isEqualTo(result2);
    verify(voivodeshipRepository, times(1)).findByCodeIgnoreCase(anyString());
  }

  @Test
  void shouldThrowExceptionWhenVoivodeshipNotFoundByCode() {
    when(voivodeshipRepository.findByCodeIgnoreCase("UNKNOWN")).thenReturn(Optional.empty());

    assertThatThrownBy(() -> voivodeshipService.getVoivodeshipByCode("UNKNOWN"))
        .isExactlyInstanceOf(VoivodeshipNotFoundException.class);
  }
}
