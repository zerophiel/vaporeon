package com.momotaro.vaporeon.service.itemdetail;

import com.momotaro.vaporeon.constant.ErrorMessages;
import com.momotaro.vaporeon.repository.itemdetail.ItemDetailRepository;
import com.momotaro.vaporeon.util.Precondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDetailServiceBean implements ItemDetailService {
    @Autowired
    ItemDetailRepository itemDetailRepository;

    @Override
    public void createNewItem (String itemName,String itemPackUnit, Integer buyPackPriceAvg) {
        Precondition.checkArgument(this.itemDetailRepository.findByItemNameAndItemPackUnit(itemName,itemPackUnit).isEmpty(), ErrorMessages.ERR_DATA_ALREADY_EXIST);
        this.itemDetailRepository.createNewItem(itemName,itemPackUnit,buyPackPriceAvg);
    }
}
