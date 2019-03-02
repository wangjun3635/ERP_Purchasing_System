package com.team.purchasing.mapper.order;

import com.team.purchasing.bean.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午10:54
 */
public interface OrderDao {

    public List<Order> queryOrderList(@Param("order") Order order);

    public int queryOrderCount(@Param("order") Order order);
}
