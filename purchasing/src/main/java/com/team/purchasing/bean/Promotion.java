package com.team.purchasing.bean;

import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:28
 */
@Data
public class Promotion {

    private int id;

    private String title;

    private String attachmentImg;

    private String content;

    private String createTime;

    private int createUserId;

    private String updateTime;

    private int updateUserId;

}
