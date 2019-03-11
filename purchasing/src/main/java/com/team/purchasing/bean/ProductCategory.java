package com.team.purchasing.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午3:57
 * 产品类别表
 */
@Data
public class ProductCategory implements Serializable {

    private Integer id;

    private String name;

    private String level;

    private String parentId;

    private Integer isDeleted;

    private String createTime;

    private Integer createUserId;

    private String updateTime;

    private Integer updateUserId;

}
