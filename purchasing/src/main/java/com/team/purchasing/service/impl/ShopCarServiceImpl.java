package com.team.purchasing.service.impl;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.mapper.ShopCarDao;
import com.team.purchasing.service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:53
 */
@Service
@Slf4j
public class ShopCarServiceImpl implements ShopCarService {

    @Resource
    private ShopCarDao shopCarDao;

    @Override
    @Transactional
    public int addShopCarProduct(ShopCar shopCar) {

        try {
            int result = shopCarDao.addShopCarProduct(shopCar);
            return result;
        }catch (Exception e) {
            log.error("购物车商品添加失败,shopCar为:{}", shopCar, e);
            throw new RuntimeException("购物车商品添加失败");
        }

    }

    @Override
    @Transactional
    public int deleteShopCarProduct(ShopCar shopCar) {

        try {
            int result = shopCarDao.deleteShopCarProduct(shopCar);
            return result;
        }catch (Exception e) {
            log.error("购物车商品删除失败,shopCar为:{}", shopCar, e);
            throw new RuntimeException("购物车商品删除失败");
        }

    }

	@Override
	public List<ShopCar> queryShopCarList(ShopCar shopCar) {
		return shopCarDao.queryShopCarList(shopCar);
	}
}
