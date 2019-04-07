package com.team.purchasing.controller.request.shopcar;

import com.team.purchasing.bean.shopcar.ShopCarBatchDelete;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:6/4/19 下午11:51
 */
@Data
@ApiModel(description = "购物车删除请求实体类")
public class ShopCarDelteBatchRequest extends GeneralRequest {

    @ApiModelProperty(value = "购物车信息")
    private List<ShopCarBatchDelete> shopCarBatchDeletes;
}
