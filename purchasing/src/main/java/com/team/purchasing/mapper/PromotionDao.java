package com.team.purchasing.mapper;

import com.team.purchasing.bean.Promotion;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:37
 */
public interface PromotionDao {

    public List<Promotion> queryPromotionList(Promotion promotion);

    public int queryPromotionCount();

    public int addPromotion(Promotion promotion);

    public int updatePromotion(Promotion promotion);

}
