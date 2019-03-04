package com.team.purchasing.service.impl;

import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.mapper.orderproduct.OrderProductDao;
import com.team.purchasing.service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:32
 */
@Service
@Slf4j
public class OrderProductServiceImpl implements OrderProductService {

    @Resource
    private OrderProductDao orderProductDao;

    @Override
    public List<OrderProduct> queryOrderProductList(Long orderId) {
        return orderProductDao.queryOrderProductList(orderId);
    }

    @Override
    @Transactional
    public int addOrderProduct(OrderProduct orderProduct) {

        try {
            int result = orderProductDao.addOrderProduct(orderProduct);
            return result;
        }catch (Exception e) {
            log.error("订单产品信息快照生成失败,数据为:{}", orderProduct, e);
            throw new RuntimeException("订单产品信息快照生成失败");
        }
    }
}
