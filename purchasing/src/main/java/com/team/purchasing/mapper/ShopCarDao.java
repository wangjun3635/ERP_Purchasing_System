package com.team.purchasing.mapper;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.bean.shopcar.ShopCarBatchDelete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:54
 */
public interface ShopCarDao {

    public int addShopCarProduct(@Param("shopCar") ShopCar shopCar);

    public int deleteShopCarProduct(@Param("shopCar") ShopCar shopCar);

    public void batchDeleteShopCarProduct(@Param("shopCarBatchDeletes") List<ShopCarBatchDelete> shopCarBatchDeletes);
    
    public List<ShopCar> queryShopCarList(@Param("shopCar") ShopCar shopCar);

    public int queryShopCatCount(@Param("shopCar") ShopCar shopCar);

    public int updateShopCarProduct(@Param("shopCarId") Integer shopCarId, @Param("quantity") Integer quantity);

}
