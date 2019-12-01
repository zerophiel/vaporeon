package com.momotaro.vaporeon.repository.itemdetail;

import com.momotaro.vaporeon.model.itemdetail.ItemDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemDetailRepository extends JpaRepository<ItemDetail, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO item_details (item_name,item_pack_unit,buy_pack_price_avg) VALUES (?1,?2,?3)", nativeQuery = true)
    void createNewItem(String itemName, String itemPackUnit, Integer buyPackPriceAvg);

    List<ItemDetail> findByItemNameAndItemPackUnit(String itemName, String itemPackUnit);

    void deleteById(Long Id);

    List<ItemDetail> findAll();

    @Transactional
    @Modifying
    @Query(value = "UPDATE item_details SET item_name = ?2,item_pack_unit = ?3,buy_pack_price_avg = ?4 WHERE id = ?1", nativeQuery = true)
    void updateById(Long id,String itemName,String itemPackUnit,Integer buyPackPriceAvg);
}
