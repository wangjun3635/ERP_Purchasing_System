package com.team.purchasing.bean.productcomment;

import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:16
 * 产品评价实体类
 */
@Data
public class ProductComment {

    private int id;

    private int productId;

    private int userId;

    private int star;

    private String comment;

    private String createTime;

    private int createUserId;

    private String updateTime;

    private int updateUserId;

}
