package com.team.purchasing.mapper;

import com.team.purchasing.bean.shopcar.ShopCar;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:54
 */
public interface ShopCarDao {

    public int addShopCarProduct(@Param("shopCar") ShopCar shopCar);

    public int deleteShopCarProduct(@Param("shopCar") ShopCar shopCar);
    
    public List<ShopCar> queryShopCarList(@Param("shopCar") ShopCar shopCar);

    public int queryShopCatCount(@Param("shopCar") ShopCar shopCar);

}
