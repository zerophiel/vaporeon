package com.momotaro.vaporeon.model.stock;

import com.momotaro.vaporeon.enums.StockFieldNames;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "stock")
@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = StockFieldNames.ITEM_ID)
    private String itemName;

    @Column(name = StockFieldNames.ITEM_AMOUNT_PACK)
    private Integer itemAmountPack;
}
