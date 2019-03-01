package com.team.purchasing.bean.shopcar;

import com.team.purchasing.utils.Page;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:1/3/19 下午9:35
 * 购物车实体类
 */
@Data
public class ShopCar {

    private int id;

    /** 商品Id **/
    private int productId;

    /** 医院学校供应商id **/
    private int HSCId;

    /** 用户id **/
    private int userId;

    /** 数量 **/
    private int quantity;

    /** 删除标志（0未删除，1删除） **/
    private int isValid;

    /** 创建时间 **/
    private String createTime;

    /** 创建人 **/
    private int createUserId;

    /** 最近更新时间 **/
    private String updateTime;

    /** 最近更新人id **/
    private int updateUserId;

    private Page page;

}
