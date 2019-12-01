package com.momotaro.vaporeon.repository.stock;

import com.momotaro.vaporeon.model.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface StockRepository extends JpaRepository<Stock,Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into stock (item_name,item_amount_pack,item_pack_unit) VALUES (?1,?2,?3)",nativeQuery = true)
    void createNewItem (String itemName, Integer itemAmountPack ,String itemPackUnit);
}
