package com.team.purchasing.service.impl;

import com.team.purchasing.bean.Product;
import com.team.purchasing.bean.booking.OrderBooking;
import com.team.purchasing.bean.booking.ProductStamp;
import com.team.purchasing.bean.orderproduct.OrderProduct;
import com.team.purchasing.mapper.booking.OrderBookingDao;
import com.team.purchasing.mapper.orderproduct.OrderProductDao;
import com.team.purchasing.service.OrderBookingService;
import com.team.purchasing.service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    private OrderProductDao orderProductDao;

    @Resource
    private OrderProductService orderProductService;

    @Override
    @Transactional
    public int createBookingOrder(OrderBooking orderBooking) {

        try {

            //获取产品快照信息
            List<ProductStamp> productStampList = orderBooking.getProductStamp();

            //计算总金额
            BigDecimal totalAmount = productStampList.stream()
                    .map(productStamp -> productStamp.getProductPrice()
                            .multiply(new BigDecimal(productStamp.getProductQuantity())))
                    // 使用reduce聚合函数,实现累加器
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            orderBooking.setTotalAmount(totalAmount);

            int result = orderBookingDao.createBookingOrder(orderBooking);
            int bookingOrderId = orderBooking.getId();

            //生成订单商品快照订单
            OrderProduct orderProduct = new OrderProduct();

            //初始化orderProduct快照信息
            orderProduct.setOrderId(bookingOrderId);
            orderProduct.setOrderNumber(orderBooking.getOrderNumber());

            // TODO: 4/3/19 订单商品快照
            productStampList.stream()
                    .filter(productStamp -> productStamp != null)
                    .forEach(productStamp -> {
                        try {
                            orderProduct.setProductId(productStamp.getProductId());
                            orderProduct.setProductName(productStamp.getProductName());
                            orderProduct.setProductPrice(productStamp.getProductPrice());
                            orderProduct.setProductQuantity(productStamp.getProductQuantity());
                            orderProductDao.addOrderProduct(orderProduct);
                        }catch (Exception e) {
                            log.error("快照数据生成失败,orderId为：{}, productId为:{}", bookingOrderId, productStamp , e);
                            throw new RuntimeException("订单产品信息快照数据生成失败");
                        }
                    });
           
            return result;
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
