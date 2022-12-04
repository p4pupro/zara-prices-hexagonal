package com.altia.infra.inputport;

import com.altia.domain.Price;
import java.time.LocalDateTime;

public interface PriceServicePort {
  Price findPrices(LocalDateTime date, Long productId, Long brandId);
}
