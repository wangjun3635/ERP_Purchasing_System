package com.team.purchasing.service;

import com.team.purchasing.bean.booking.OrderBooking;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:55
 */
public interface OrderBookingService {

    //创建预定订单
    public OrderBooking createBookingOrder(OrderBooking orderBooking);

    //取消订单
    public int cancelBookingOrder(OrderBooking orderBooking);

    //修改订单
    public int updateBookingOrder(OrderBooking orderBooking);

}
