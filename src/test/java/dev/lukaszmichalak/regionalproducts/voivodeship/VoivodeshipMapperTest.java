package dev.lukaszmichalak.regionalproducts.voivodeship;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VoivodeshipMapperTest {

  @Test
  void testMapping() {
    var ds = VoivodeshipStub.ds;

    var dsDto = VoivodeshipMapper.toDto(ds);

    assertThat(dsDto).isNotNull();
    assertThat(dsDto.id()).isEqualTo(ds.getId());
    assertThat(dsDto.code()).isEqualTo(ds.getCode());
    assertThat(dsDto.name()).isEqualTo(ds.getName());
    assertThat(dsDto.descriptionEn()).isEqualTo(ds.getDescriptionEn());
    assertThat(dsDto.descriptionPl()).isEqualTo(ds.getDescriptionPl());
    assertThat(dsDto.coatOfArmsFilename()).isEqualTo(ds.getCoatOfArmsFilename());
  }
}
