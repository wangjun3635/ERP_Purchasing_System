package com.team.purchasing.bean.booking;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:28
 * 订单预定实体类
 */
@Data
public class OrderBooking {

    private int id;

    /** 商品id **/
    private List<Integer> productIds;

    /** 用户id **/
    private int userId;

    /** 医院或者院校id **/
    private int HCId;

    /** 订单编号 **/
    private String orderNumber;

    /** 订单总金额 **/
    private BigDecimal totalAmount;

    /** 订单状态 1：预订单 2：科研处已审核 3：采购处已审核 **/
    private int orderStatus;

    /** 订单备注 **/
    private String orderRemark;

    /** 物流单号 **/
    private String deliveryNumber;

    /** 收货人名字 **/
    private String receiverName;

    /** 收货人电话 **/
    private String receiverPhone;

    /** 收货人邮编**/
    private String receiverPostCode;

    /** 收货省、直辖市 **/
    private String receiverProvince;

    /** 收货城市 **/
    private String receiverCity;

    /** 详细地址 **/
    private String receiverRegion;

    /** 创建时间 **/
    private String createTime;

    /** 创建用户id **/
    private int createUserId;

    /** 最近一次修改时间 **/
    private String updateTime;

    /** 最近修改用户id **/
    private int updateUserId;

}
