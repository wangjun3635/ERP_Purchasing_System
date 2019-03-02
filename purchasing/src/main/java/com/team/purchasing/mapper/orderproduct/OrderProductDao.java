package com.team.purchasing.mapper.orderproduct;

import com.team.purchasing.bean.orderproduct.OrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:2/3/19 上午11:23
 */
public interface OrderProductDao {

    /** 订单id查询产品信息**/
    public List<OrderProduct> queryOrderProductList(@Param("orderId") Long orderId);

}
