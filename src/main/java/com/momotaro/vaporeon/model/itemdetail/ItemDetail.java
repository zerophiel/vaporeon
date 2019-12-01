package com.momotaro.vaporeon.model.itemdetail;

import com.momotaro.vaporeon.enums.ItemDetailFieldNames;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table (name = "item_details")
@Entity
public class ItemDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = ItemDetailFieldNames.ITEM_NAME)
    private String itemName;

    @Column(name = ItemDetailFieldNames.BUY_PACK_PRICE_AVG)
    private Integer buyPackPriceAvg;

    @Column(name = ItemDetailFieldNames.ITEM_PACK_UNIT)
    private String itemPackUnit;
}
