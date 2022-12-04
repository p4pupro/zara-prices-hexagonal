package com.altia.application;

import com.altia.domain.Price;
import com.altia.infra.entity.PriceEntity;
import com.altia.infra.inputport.PriceServicePort;
import com.altia.infra.outputport.PricesRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPrice implements PriceServicePort {

    @Autowired
    private PricesRepository pricesRepository;

  @Override
  public Price findPrices(LocalDateTime date, Long productId, Long brandId) {
    List<PriceEntity> priceEntities = pricesRepository.findPrice(productId, brandId, date);
    final var prices = priceEntities.stream().map(PriceEntity::toDomain).toList();
    return prices.stream().max(Comparator.comparing(Price::getPriority)).orElse(null);
  }
}
