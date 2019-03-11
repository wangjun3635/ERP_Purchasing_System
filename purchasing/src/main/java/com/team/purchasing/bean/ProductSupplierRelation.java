package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午3:00
 * 产品供应商关联表
 */
@Data
public class ProductSupplierRelation {

    /** 产品模块 **/
    private Integer productId;

    private String productName;

    private String barCode;

    //销售单位
    private String unit;

    //单价
    private BigDecimal unitPrice;

    //货期  1:现货2：期货
    private Integer deliveryTime;

    //产品类别，一级、二级、三级
    private Integer productLevelFirst;

    private Integer productLevelSecond;

    private Integer productLevelThird;

    /** 供应商模块 **/
    private String supplierName;

    private Integer salesAreaType;

    private Integer salesProvince;

    private Page page;

}
