package com.team.purchasing.service;

import com.team.purchasing.bean.order.Order;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:12
 */
public interface OrderService {

    public List<Order> queryOrderList(Order order);

    public int queryOrderCount(Order order);

}
