package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import dev.lukaszmichalak.regionalproducts.product.ProductStub;

public class CountStub {
    
    public static long totalCount = ProductStub.count;
    
    public static CountDto ds() {
        return new CountDto(VoivodeshipStub.ds().name(), totalCount);
    }
}
