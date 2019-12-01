package com.momotaro.vaporeon.controller.itemdetail;

import com.momotaro.vaporeon.constant.ErrorMessages;
import com.momotaro.vaporeon.dto.core.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import com.momotaro.vaporeon.dto.itemdetail.CreateNewItemRequest;
import com.momotaro.vaporeon.service.itemdetail.ItemDetailService;
import com.momotaro.vaporeon.util.Precondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
