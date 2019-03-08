package com.team.purchasing.bean.orderproduct;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午11:21
 */
@Data
public class OrderProduct {

    private int id;

    private int orderId;

    private String orderNumber;

    private int productId;

    private int branchId;

    private String productName;

    private BigDecimal productPrice;

    private int productQuantity;

    private String createTime;

    private int createUserId;

    private String updateTime;

    private int updateUserId;

}
