package com.altia.infra.inputport;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
  private Long brandId;
  private Long productId;
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd-HH.mm.ss")
  private LocalDateTime date;
}
