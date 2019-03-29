package com.team.purchasing.bean.booking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:28
 * 订单预定实体类
 */
@Data
@ApiModel(value="订单预定实体")
public class OrderBooking {

    @ApiModelProperty(value = "订单预定id")
    private Integer id;

    /** 商品快照 **/
    @ApiModelProperty(value = "商品快照")
    private List<ProductStamp> productStamp;

    /** 用户id **/
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /** 医院或者院校id **/
    @ApiModelProperty(value = "医院或者院校id")
    private Long HCId;

    /** 订单编号 **/
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    /** 订单总金额 **/
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;

    /** 订单状态 1：预订单 2：科研处已审核 3：采购处已审核 **/
    @ApiModelProperty(value = "订单状态 1：预订单 2：科研处已审核 3：采购处已审核 ")
    private Integer orderStatus;

    /** 订单备注 **/
    @ApiModelProperty(value = "订单备注")
    private String orderRemark;

    /** 物流单号 **/
    @ApiModelProperty(value = "物流单号")
    private String deliveryNumber;

    /** 收货人名字 **/
    @ApiModelProperty(value = "收货人名字")
    private String receiverName;

    /** 收货人电话 **/
    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    /** 收货人邮编**/
    @ApiModelProperty(value = "收货人邮编")
    private String receiverPostCode;

    /** 收货省、直辖市 **/
    @ApiModelProperty(value = "收货省、直辖市")
    private String receiverProvince;

    /** 收货城市 **/
    @ApiModelProperty(value = "收货城市")
    private String receiverCity;

    /** 详细地址 **/
    @ApiModelProperty(value = "详细地址")
    private String receiverRegion;

    /** 创建时间 **/
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /** 创建用户id **/
    @ApiModelProperty(value = "创建用户id")
    private Long createUserId;

    /** 最近一次修改时间 **/
    @ApiModelProperty(value = "最近一次修改时间")
    private String updateTime;

    /** 最近修改用户id **/
    @ApiModelProperty(value = "最近修改用户id")
    private Long updateUserId;

    @ApiModelProperty(value = "下单来源")
    private Integer orderFrom;

}
