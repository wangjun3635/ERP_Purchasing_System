package com.team.purchasing.mapper;

import com.team.purchasing.bean.Promotion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:37
 */
public interface PromotionDao {

    public List<Promotion> queryAll();

    public Promotion queryById(@Param("id") int id);

    public int addPromotion(@Param("promotion") Promotion promotion);

    public int updatePromotion(@Param("promotion") Promotion promotion);

}
