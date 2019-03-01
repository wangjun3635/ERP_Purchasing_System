package com.team.purchasing.controller.request.shopcar;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:47
 */
@Data
@ApiModel(description = "购物车请求实体类")
public class ShopCarRequest extends GeneralRequest {

    @ApiModelProperty(value = "购物车信息")
    private ShopCar shopCar;

}
