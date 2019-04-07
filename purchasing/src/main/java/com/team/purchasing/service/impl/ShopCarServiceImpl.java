package com.team.purchasing.service.impl;

import com.team.purchasing.bean.shopcar.ShopCar;
import com.team.purchasing.bean.shopcar.ShopCarBatchDelete;
import com.team.purchasing.mapper.ShopCarDao;
import com.team.purchasing.service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

            //判断当前是否重复添加商品信息
            shopCar.getPage().init(9999);
            List<ShopCar> shopCars = shopCarDao.queryShopCarList(shopCar);

            if(!CollectionUtils.isEmpty(shopCars)){
                try {
                    shopCars.stream()
                            .filter(x -> x.getId() != null)
                            .forEach(x -> {
                                shopCarDao.updateShopCarProduct(x.getId(), shopCar.getQuantity());
                            });
                }catch (Exception e) {
                    log.error("添加购物车信息失败,当前有重复商品信息:{}", shopCar, e);
                    throw new RuntimeException();
                }

                return 1;
            }


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
    public int batchDeleteShopCarProduct(List<ShopCarBatchDelete> shopCarBatchDeletes) {

        try {
            shopCarDao.batchDeleteShopCarProduct(shopCarBatchDeletes);
            return 1;
        }catch (Exception e) {
            log.error("购物车商品批量删除失败,shopCar为:{}", shopCarBatchDeletes, e);
            throw new RuntimeException("购物车商品批量删除失败");
        }

    }

    @Override
	public List<ShopCar> queryShopCarList(ShopCar shopCar) {
		return shopCarDao.queryShopCarList(shopCar);
	}

    @Override
    public int queryShopCatCount(ShopCar shopCar) {
        return shopCarDao.queryShopCatCount(shopCar);
    }
}
