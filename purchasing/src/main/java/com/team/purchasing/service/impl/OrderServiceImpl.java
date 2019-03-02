package com.team.purchasing.service.impl;

import com.team.purchasing.bean.order.Order;
import com.team.purchasing.mapper.order.OrderDao;
import com.team.purchasing.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:12
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public List<Order> queryOrderList(Order order) {
        return orderDao.queryOrderList(order);
    }

    @Override
    public int queryOrderCount(Order order) {
        return orderDao.queryOrderCount(order);
    }

}
