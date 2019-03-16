package com.team.purchasing.mapper.booking;

import com.team.purchasing.bean.booking.OrderBooking;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午10:41
 */
public interface OrderBookingDao {

    //创建预定订单
    public int createBookingOrder(OrderBooking orderBooking);

    //取消订单
    public int cancelBookingOrder(@Param("orderBooking") OrderBooking orderBooking);

    //修改订单
    public int updateBookingOrder(@Param("orderBooking") OrderBooking orderBooking);

}
