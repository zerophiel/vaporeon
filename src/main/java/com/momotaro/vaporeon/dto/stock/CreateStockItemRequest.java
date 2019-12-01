package com.momotaro.vaporeon.dto.stock;

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
public class CreateStockItemRequest implements Serializable {
    private String itemName;
    private Integer itemAmountPack;
    private String itemPackUnit;

    public String getItemName() {
        return itemName;
    }

    public Integer getItemAmountPack() {
        return itemAmountPack;
    }

    public String getItemPackUnit() {
        return itemPackUnit;
    }
}
