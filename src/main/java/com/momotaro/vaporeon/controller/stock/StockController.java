package com.momotaro.vaporeon.controller.stock;

import com.momotaro.vaporeon.dto.core.BaseResponse;
import com.momotaro.vaporeon.dto.stock.CreateStockItemRequest;
import com.momotaro.vaporeon.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = StockControllerPath.BASE_PATH)
public class StockController {
    @Autowired
    StockService stockService;
    @RequestMapping(value = StockControllerPath.UPDATE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createNewItem (@RequestBody CreateStockItemRequest request) throws Exception {
        this.stockService.createNewItem(request.getItemName(),request.getItemAmountPack(),request.getItemPackUnit());
        return new BaseResponse(null,null,true);
    }
}
