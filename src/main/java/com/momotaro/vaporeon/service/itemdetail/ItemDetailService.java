package com.momotaro.vaporeon.service.itemdetail;

import com.momotaro.vaporeon.model.itemdetail.ItemDetail;

import java.util.List;

public interface ItemDetailService {
    void createNewItem (String itemName,String itemPackUnit, Integer buyPackPriceAvg) throws Exception;
    void deleteById (Long id) throws Exception;
    void updateById (Long id, String itemName,String itemPackUnit, Integer buyPackPriceAvg) throws Exception;
    List<ItemDetail> findAll() throws Exception;
}
