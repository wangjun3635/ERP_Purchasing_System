package com.team.purchasing.service.impl;

import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.mapper.orderproduct.OrderProductDao;
import com.team.purchasing.service.OrderProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:32
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Resource
    private OrderProductDao orderProductDao;

    @Override
    public List<OrderProduct> queryOrderProductList(Long orderId) {
        return orderProductDao.queryOrderProductList(orderId);
    }
}
