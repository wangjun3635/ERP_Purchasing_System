package com.team.purchasing.service.impl;

import com.team.purchasing.bean.order.Order;
import com.team.purchasing.mapper.order.OrderDao;
import com.team.purchasing.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:12
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public List<Order> queryOrderList(Order order) {

        try {
            List<Order> orderList = orderDao.queryOrderList(order);
            return orderList;
        }catch (Exception e) {
            log.error("查询数据异常,异常信息为: {}", e);
            throw new RuntimeException("[OrderServiceImpl] 查询数据异常");
        }

    }

    @Override
    public int queryOrderCount(Order order) {

        try {
            int count = orderDao.queryOrderCount(order);
            return count;
        }catch (Exception e) {
            log.error("查询count数据异常,异常信息为: {}", e);
            throw new RuntimeException("[OrderServiceImpl] 查询count数据异常");
        }

    }

}
