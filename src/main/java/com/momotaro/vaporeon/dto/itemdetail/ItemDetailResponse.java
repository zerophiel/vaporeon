package com.momotaro.vaporeon.dto.itemdetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailResponse implements Serializable {
    private Long Id;
    private String itemName;
    private String itemPackUnit;
    private Integer buyPackPriceAvg;
}
