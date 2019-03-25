package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 上午11:28
 * 产品信息表
 */
@Data
@ApiModel(value="产品实体")
public class Product implements Serializable {

    @ApiModelProperty(value = "产品id")
    private Integer id;

    //料件系统编号
    @ApiModelProperty(value = "料件系统编号")
    private String code;

    //商品条码
    @ApiModelProperty(value = "商品条码")
    private String barCode;

    //商品名称
    @ApiModelProperty(value = "商品名称")
    private String name;

    //通用名称
    @ApiModelProperty(value = "通用名称")
    private String genericName;

    //简称
    @ApiModelProperty(value = "产品id")
    private String shortName;

    //规格型号
    @ApiModelProperty(value = "规格型号")
    private String specs;

    //销售单位
    @ApiModelProperty(value = "销售单位")
    private String unit;

    //单价
    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    //生产商
    @ApiModelProperty(value = "生产商")
    private String manufacturer;

    //组成成分
    @ApiModelProperty(value = "组成成分")
    private String components;

    //用途
    @ApiModelProperty(value = "用途")
    private String purpose;

    //不良反应
    @ApiModelProperty(value = "不良反应")
    private String taboo;

    //质量标准
    @ApiModelProperty(value = "质量标准")
    private String qualityStandard;

    //装箱规格
    @ApiModelProperty(value = "装箱规格")
    private String packingSpecs;

    //类别
    @ApiModelProperty(value = "类别")
    private String catalogs;

    //注册证号
    @ApiModelProperty(value = "注册证号")
    private String registerNO;

    //注册证有效期
    @ApiModelProperty(value = "注册证有效期")
    private String registerExpireDate;

    //许可证号
    @ApiModelProperty(value = "许可证号")
    private String licenseNO;

    //许可证有效期
    @ApiModelProperty(value = "许可证有效期")
    private String licenseExpireDate;

    //运输条件
    @ApiModelProperty(value = "运输条件")
    private String transRequire;

    //存储条件
    @ApiModelProperty(value = "存储条件")
    private String storageRequire;

    //最低库存量(预留)
    @ApiModelProperty(value = "最低库存量")
    private long minStock;

    //最大库存量（预留）
    @ApiModelProperty(value = "最大库存量")
    private long maxStock;

    //备注
    @ApiModelProperty(value = "备注")
    private String remark;

    //数据状态
    @ApiModelProperty(value = "数据状态")
    private Integer dataStatus;

    //审批状态
    @ApiModelProperty(value = "审批状态")
    private Integer auditStatus;

    //审批流程编号
    @ApiModelProperty(value = "审批流程编号")
    private String auditFlowCode;

    //审批节点序号
    @ApiModelProperty(value = "审批节点序号")
    private Integer auditNodeIndex;

    //可用标志（0不可用，1可用）
    @ApiModelProperty(value = "可用标志（0不可用，1可用）")
    private Integer isEnabled;

    //删除标志（0未删除，1删除）
    @ApiModelProperty(value = "删除标志（0未删除，1删除）")
    private Integer isDeleted;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    //创建人id
    @ApiModelProperty(value = "创建人id")
    private Integer createUserId;

    //最近更新时间
    @ApiModelProperty(value = "最近更新时间")
    private String updateTime;

    //最近更新人id
    @ApiModelProperty(value = "最近更新人id")
    private Integer updateUserId;

    //供应商id
    @ApiModelProperty(value = "供应商id")
    private Integer supplierId;

    //品牌id
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    //货期  1:现货2：期货
    @ApiModelProperty(value = "货期  1:现货2：期货")
    private Integer deliveryType;

    //产品类别 一级、二级、三级
    @ApiModelProperty(value = "产品类别 一级")
    private Integer productLevelFirst;

    @ApiModelProperty(value = "产品类别 二级")
    private Integer productLevelSecond;

    @ApiModelProperty(value = "产品类别 三级")
    private Integer productLevelThird;

    @ApiModelProperty(value = "分页")
    private Page page;

}
