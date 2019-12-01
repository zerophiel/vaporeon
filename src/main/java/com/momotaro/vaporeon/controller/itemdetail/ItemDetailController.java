package com.momotaro.vaporeon.controller.itemdetail;

import com.momotaro.vaporeon.constant.ErrorMessages;
import com.momotaro.vaporeon.dto.core.BaseResponse;
import com.momotaro.vaporeon.dto.core.ListBaseResponse;
import com.momotaro.vaporeon.dto.core.Metadata;
import com.momotaro.vaporeon.dto.itemdetail.*;
import org.springframework.util.StringUtils;
import com.momotaro.vaporeon.service.itemdetail.ItemDetailService;
import com.momotaro.vaporeon.util.Precondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = ItemDetailControllerPath.BASE_PATH)
public class ItemDetailController {
    @Autowired
    ItemDetailService itemDetailService;


    @RequestMapping(value = ItemDetailControllerPath.CREATE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createNewItem(@RequestBody CreateNewItemRequest request) throws Exception {
        Precondition.checkArgument(!StringUtils.isEmpty(request.getItemName()), ErrorMessages.ERR_ITEM_NAME_MUST_NOT_BE_BLANK);
        this.itemDetailService.createNewItem(request.getItemName(), request.getItemPackUnit(), request.getBuyPackPriceAvg());
        return new BaseResponse(null, null, true);
    }

    @RequestMapping(value = ItemDetailControllerPath.DELETE, method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse deleteItem (@RequestParam Long Id, @RequestBody DeleteItemRequest request) throws Exception {
        Precondition.checkArgument(!StringUtils.isEmpty(Id),ErrorMessages.ERR_DATA_NOT_FOUND);
        Precondition.checkArgument((request.getId().equals(Id)),ErrorMessages.ERR_DATA_NOT_FOUND);
        this.itemDetailService.deleteById(Id);
        return new BaseResponse(null,null,true);
    }

    @RequestMapping(value = ItemDetailControllerPath.UPDATE, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse updateItem (@RequestParam Long Id, @RequestBody UpdateItemRequest request) throws Exception {
        Precondition.checkArgument(!StringUtils.isEmpty(request.getId()),ErrorMessages.ERR_DATA_NOT_FOUND);
        Precondition.checkArgument((request.getId().equals(Id)),ErrorMessages.ERR_DATA_NOT_FOUND);
        this.itemDetailService.updateById(request.getId(),request.getItemName(),request.getItemPackUnit(),request.getBuyPackPriceAvg());
        return new BaseResponse(null,null,true);
    }

    @RequestMapping (value = ItemDetailControllerPath.READ, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListBaseResponse readItem () throws Exception {
        return new ListBaseResponse(null,null,true,this.itemDetailService.findAll(),new Metadata());
    }
}
