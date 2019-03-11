package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 上午11:28
 * 产品信息表
 */
@Data
public class Product implements Serializable {

    private Integer id;

    //料件系统编号
    private String code;

    //商品条码
    private String barCode;

    //商品名称
    private String name;

    //通用名称
    private String genericName;

    //简称
    private String shortName;

    //规格型号
    private String specs;

    //销售单位
    private String unit;

    //单价
    private BigDecimal unitPrice;

    //生产商
    private String manufacturer;

    //组成成分
    private String components;

    //用途
    private String purpose;

    //不良反应
    private String taboo;

    //质量标准
    private String qualityStandard;

    //装箱规格
    private String packingSpecs;

    //类别
    private String catalogs;

    //注册证号
    private String registerNO;

    //注册证有效期
    private String registerExpireDate;

    //许可证号
    private String licenseNO;

    //许可证有效期
    private String licenseExpireDate;

    //运输条件
    private String transRequire;

    //存储条件
    private String storageRequire;

    //最低库存量(预留)
    private long minStock;

    //最大库存量（预留）
    private long maxStock;

    //备注
    private String remark;

    //数据状态
    private Integer dataStatus;

    //审批状态
    private Integer auditStatus;

    //审批流程编号
    private String auditFlowCode;

    //审批节点序号
    private Integer auditNodeIndex;

    //可用标志（0不可用，1可用）
    private Integer isEnabled;

    //删除标志（0未删除，1删除）
    private Integer isDeleted;

    //创建时间
    private String createTime;

    //创建人id
    private Integer createUserId;

    //最近更新时间
    private String updateTime;

    //最近更新人id
    private Integer updateUserId;

    //供应商id
    private Integer supplierId;

    //品牌id
    private Integer brandId;

    //货期  1:现货2：期货
    private Integer deliveryTime;

    //产品类别 一级、二级、三级
    private Integer productLevelFirst;

    private Integer productLevelSecond;

    private Integer productLevelThird;

    private Page page;

}
