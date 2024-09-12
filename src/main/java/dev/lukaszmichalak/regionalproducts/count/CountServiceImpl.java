package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CountServiceImpl implements CountService {
    
    final CountRepository countRepository;
    
    @Override
    public List<CountDto> getCounts() {
        return countRepository.getCounts().stream().map(Count::toDto).toList();
    }
}
