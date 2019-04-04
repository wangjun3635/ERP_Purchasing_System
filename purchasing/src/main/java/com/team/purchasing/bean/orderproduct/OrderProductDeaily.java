package com.team.purchasing.bean.orderproduct;

import com.team.purchasing.bean.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 018399
 * @Date: 2019/4/4 10:08
 * @Description:
 */
@Data
@ApiModel(value="订单产品详细信息")
public class OrderProductDeaily {

    @ApiModelProperty(value = "订单产品id")
    private Integer id;

    @ApiModelProperty(value = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @ApiModelProperty(value = "产品信息")
    private Product product;

    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "购买数量")
    private Integer productQuantity;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private Integer createUserId;

    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    @ApiModelProperty(value = "最近更新人")
    private Integer updateUserId;

}
