package com.momotaro.vaporeon.service.stock;

import com.momotaro.vaporeon.model.stock.Stock;
import com.momotaro.vaporeon.repository.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceBean implements StockService{
    @Autowired
    private StockRepository stockRepository;

    @Override
    public void createNewItem (String itemName, Integer itemAmountPack ,String itemPackUnit) {
        this.stockRepository.createNewItem(itemName,itemAmountPack,itemPackUnit);
    }
}
