package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;

import java.util.List;

public interface CountService {
    
    List<CountDto> getCounts();
}
