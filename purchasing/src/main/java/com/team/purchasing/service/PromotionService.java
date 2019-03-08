package com.team.purchasing.service;

import com.team.purchasing.bean.Promotion;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:56
 */
public interface PromotionService {

    public List<Promotion> queryPromotionList(Promotion promotion);

    public int queryPromotionCount();

    public int addPromotion(Promotion promotion);

    public int updatePromotion(Promotion promotion);

}
