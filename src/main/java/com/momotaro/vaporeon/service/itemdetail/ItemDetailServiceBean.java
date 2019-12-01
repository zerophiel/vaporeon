package com.momotaro.vaporeon.service.itemdetail;

import com.momotaro.vaporeon.constant.ErrorMessages;
import com.momotaro.vaporeon.model.itemdetail.ItemDetail;
import com.momotaro.vaporeon.repository.itemdetail.ItemDetailRepository;
import com.momotaro.vaporeon.util.Precondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemDetailServiceBean implements ItemDetailService {
    @Autowired
    ItemDetailRepository itemDetailRepository;
    @Override
    public void createNewItem (String itemName,String itemPackUnit, Integer buyPackPriceAvg) {
        Precondition.checkArgument(this.itemDetailRepository.findByItemNameAndItemPackUnit(itemName,itemPackUnit).isEmpty(), ErrorMessages.ERR_DATA_ALREADY_EXIST);
        this.itemDetailRepository.createNewItem(itemName,itemPackUnit,buyPackPriceAvg);
    }
    @Override
    public List<ItemDetail> findAll(){
        return itemDetailRepository.findAll();
    }

    @Override
    public void deleteById (Long id) {
        this.itemDetailRepository.deleteById(id);
    }

    @Override
    public void updateById (Long id, String itemName,String itemPackUnit, Integer buyPackPriceAvg) {
        this.itemDetailRepository.updateById(id,itemName,itemPackUnit,buyPackPriceAvg);
    }
}
