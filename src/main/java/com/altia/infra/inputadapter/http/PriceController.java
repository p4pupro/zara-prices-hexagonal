package com.altia.infra.inputadapter.http;


import com.altia.domain.Price;
import com.altia.infra.inputport.PriceRequest;
import com.altia.infra.inputport.PriceServicePort;
import com.altia.infra.outputadapter.h2repository.PriceMapper;
import com.altia.infra.outputadapter.h2repository.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/prices")
public class PriceController {

  private final PriceServicePort priceServicePort;

  @Operation(summary = "Find prices by date brandId and productId")
  @GetMapping()
  PriceResponse findPrice(final @RequestBody PriceRequest priceRequest) {
    Price price = priceServicePort.findPrices(priceRequest.getDate(), priceRequest.getProductId(), priceRequest.getBrandId());
    return PriceMapper.toResponse(price);
  }
}