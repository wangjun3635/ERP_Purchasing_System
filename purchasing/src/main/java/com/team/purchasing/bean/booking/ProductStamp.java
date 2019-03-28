package com.team.purchasing.bean.booking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: 018399
 * @Date: 2019/3/28 11:45
 * @Description:
 */
@Data
@ApiModel(value="产品快照实体")
public class ProductStamp implements Serializable {

    @ApiModelProperty(value = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "产品单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer productQuantity;

}
