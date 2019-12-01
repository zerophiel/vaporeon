package com.momotaro.vaporeon.service.stock;

public interface StockService {
    void createNewItem (String itemName, Integer itemAmountPack ,String itemPackUnit) throws Exception;
}
