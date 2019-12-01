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
public class CreateNewItemRequest implements Serializable {
    private String itemName;
    private String itemPackUnit;
    private Integer buyPackPriceAvg;

    public String getItemName() {
        return itemName;
    }
    public String getItemPackUnit() {
        return itemPackUnit;
    }
    public Integer getBuyPackPriceAvg() {
        return buyPackPriceAvg;
    }
//    private String supplierId; NOT IMPLEMENTED YET
}
