package com.team.purchasing.service;

import java.util.List;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.bean.shopcar.ShopCarBatchDelete;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:52
 */
public interface ShopCarService {

    public int addShopCarProduct(ShopCar shopCar);

    public int deleteShopCarProduct(ShopCar shopCar);

    public int batchDeleteShopCarProduct(List<ShopCarBatchDelete> shopCarBatchDeletes);

    public List<ShopCar> queryShopCarList(ShopCar shopCar);

    public int queryShopCatCount(ShopCar shopCar);

}
