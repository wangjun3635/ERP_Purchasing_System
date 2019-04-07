package com.team.purchasing.bean.shopcar;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:6/4/19 下午11:50
 */
@Data
public class ShopCarBatchDelete {

    @ApiModelProperty(value = "购物车id")
    private Integer id;

    /** 商品Id **/
    @ApiModelProperty(value = "产品id")
    private Integer productId;

    /** 医院学校供应商id **/
    @ApiModelProperty(value = "医院学校供应商id")
    private Long HSCId;

    /** 用户id **/
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /** 数量 **/
    @ApiModelProperty(value = "数量")
    private Integer quantity;

    /** 删除标志（0未删除，1删除） **/
    @ApiModelProperty(value = "删除标志（0未删除，1删除")
    private Integer isValid;

    /** 创建时间 **/
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /** 创建人 **/
    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    /** 最近更新时间 **/
    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    /** 最近更新人id **/
    @ApiModelProperty(value = "最近更新人id")
    private Long updateUserId;

}
