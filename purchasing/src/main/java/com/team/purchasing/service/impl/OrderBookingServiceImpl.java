package com.team.purchasing.service.impl;

import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.mapper.booking.OrderBookingDao;
import com.team.purchasing.service.OrderBookingService;
import com.team.purchasing.service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:56
 */
@Service
@Slf4j
public class OrderBookingServiceImpl implements OrderBookingService {

    @Resource
    private OrderBookingDao orderBookingDao;

    @Resource
    private OrderProductService orderProductService;

    @Override
    @Transactional
    public int createBookingOrder(OrderBooking orderBooking) {

        try {
            int bookingOrder = orderBookingDao.createBookingOrder(orderBooking);

            //生成订单商品快照订单
            List<Integer> productIds = orderBooking.getProductIds();
            OrderProduct orderProduct = new OrderProduct();

            // TODO: 4/3/19 订单商品快照 
            productIds.stream()
                    .filter(x -> x != null)
                    .forEach(x -> {
                        try {
                            orderProductService.addOrderProduct(orderProduct);
                        }catch (Exception e) {
                            log.error("快照数据生成失败,orderId为：{}, productId为:{}", orderBooking.getId(), x , e);
                            throw new RuntimeException("订单产品信息快照数据生成失败");
                        }
                    });


            return bookingOrder;
        }catch (Exception e){
            log.error("创建订单失败, 订单对象为:{}", orderBooking, e);
            throw new RuntimeException("创建预订单失败...");
        }
    }

    @Override
    @Transactional
    public int cancelBookingOrder(OrderBooking orderBooking) {
        try {
            int bookingOrder = orderBookingDao.cancelBookingOrder(orderBooking);
            return bookingOrder;
        }catch (Exception e){
            log.error("取消订单失败, 订单对象为:{}", orderBooking, e);
            throw new RuntimeException("取消订单失败...");
        }
    }

    @Override
    @Transactional
    public int updateBookingOrder(OrderBooking orderBooking) {
        try {
            int bookingOrder = orderBookingDao.updateBookingOrder(orderBooking);
            return bookingOrder;
        }catch (Exception e){
            log.error("更新订单失败, 订单对象为:{}", orderBooking, e);
            throw new RuntimeException("更新订单失败...");
        }
    }
}
