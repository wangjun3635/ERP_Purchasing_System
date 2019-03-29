package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午3:00
 * 产品供应商关联表
 */
@Data
@ApiModel(value="产品供应商实体")
public class ProductSupplierRelation {
	
	//todo 产品货号字段补充

    /** 产品模块 **/
    @ApiModelProperty(value = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "产品name")
    private String productName;

    @ApiModelProperty(value = "产品条码")
    private String barCode;

    //销售单位
    @ApiModelProperty(value = "销售单位")
    private String unit;

    //单价
    @ApiModelProperty(value = "产品单价")
    private BigDecimal unitPrice;

    //货期  1:现货2：期货
    @ApiModelProperty(value = "期货：1:现货2：期货")
    private Integer deliveryType;

    //产品类别，一级、二级、三级
    @ApiModelProperty("产品类型名称")
    private String productTypeName;

    @ApiModelProperty(value = "产品类别：一级")
    private Integer productLevelFirst;

    @ApiModelProperty(value = "产品类别：二级")
    private Integer productLevelSecond;

    @ApiModelProperty(value = "产品类别：三级")
    private Integer productLevelThird;
    
    //品牌id
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "品牌name")
    private String brandName;

    /** 供应商模块 **/
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "销售区域分类")
    private Integer salesAreaType;

    @ApiModelProperty(value = "销售省份")
    private Integer salesProvince;

    @ApiModelProperty(value = "分页")
    private Page page;

}
