package com.team.purchasing.service.impl;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.mapper.ShopCarDao;
import com.team.purchasing.service.ShopCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:53
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Resource
    private ShopCarDao shopCarDao;

    @Override
    public int addShopCarProduct(ShopCar shopCar) {
        return shopCarDao.addShopCarProduct(shopCar);
    }

    @Override
    public int deleteShopCarProduct(ShopCar shopCar) {
        return shopCarDao.deleteShopCarProduct(shopCar);
    }
}
