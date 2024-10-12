package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;

record Count(String voivodeshipName, long productCount) {

  CountDto toDto() {
    return new CountDto(voivodeshipName, productCount);
  }
}
