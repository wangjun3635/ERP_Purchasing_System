package com.team.purchasing.controller.response.shopcar;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.bean.shopcar.ShopCarProduct;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:49
 */
@Data
@ApiModel(description = "购物车响应实体类")
public class ShopCarResponse extends GeneralResponse {

    @ApiModelProperty
    private List<ShopCarProduct> shopCarProducts;

}
