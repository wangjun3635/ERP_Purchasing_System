package com.team.purchasing.service;

import com.team.purchasing.bean.orderproduct.OrderProduct;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:31
 */
public interface OrderProductService {

    public List<OrderProduct> queryOrderProductList(Long orderId);

}
