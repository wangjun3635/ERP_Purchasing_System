package com.team.purchasing.service.impl;

import com.team.purchasing.bean.Promotion;
import com.team.purchasing.mapper.PromotionDao;
import com.team.purchasing.service.PromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:57
 */
@Service
@Slf4j
public class PromotionServiceImpl implements PromotionService {

    @Resource
    private PromotionDao promotionDao;

    @Override
    public List<Promotion> queryPromotionList(Promotion promotion) {

        try {
            List<Promotion> promotionList = promotionDao.queryPromotionList(promotion);
            return promotionList;
        }catch (Exception e) {
            log.error("查询数据异常,异常信息为: {}", e);
            throw new RuntimeException("[PromotionServiceImpl] 查询数据异常");
        }

    }

    @Override
    public int queryPromotionCount() {
        try {
            int count = promotionDao.queryPromotionCount();
            return count;
        }catch (Exception e) {
            log.error("查询count数据异常,异常信息为: {}", e);
            throw new RuntimeException("[PromotionServiceImpl] 查询count数据异常");
        }
    }

    @Override
    @Transactional
    public int addPromotion(Promotion promotion) {

        try {
            log.info("promotionServiceImpl入参对象为:{}", promotion);
            int result = promotionDao.addPromotion(promotion);
            return result;
        } catch (Exception e) {
            log.error("促销添加失败,添加信息为:{}", promotion.toString(), e);
            throw new RuntimeException("[PromotionServiceImpl] 添加失败");
        }
        
    }

    @Override
    @Transactional
    public int updatePromotion(Promotion promotion) {

        try {
            int result = promotionDao.updatePromotion(promotion);
            return result;
        } catch (Exception e) {
            log.error("促销更新失败,更新信息为:{}", promotion.toString(), e);
            throw new RuntimeException("[PromotionServiceImpl] 更新失败");
        }
    }
}
