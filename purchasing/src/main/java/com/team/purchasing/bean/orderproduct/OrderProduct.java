package com.team.purchasing.bean.orderproduct;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午11:21
 */
@Data
@ApiModel(value="订单产品信息实体")
public class OrderProduct {

    @ApiModelProperty(value = "订单产品id")
    private int id;

    @ApiModelProperty(value = "订单id")
    private int orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "产品id")
    private int productId;

    @ApiModelProperty(value = "品牌id")
    private int brandId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "购买数量")
    private int productQuantity;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private int createUserId;

    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    @ApiModelProperty(value = "最近更新人")
    private int updateUserId;

}
