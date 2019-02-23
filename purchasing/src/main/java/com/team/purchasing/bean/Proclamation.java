package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import lombok.Data;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:36
 */
@Data
public class Proclamation extends Page {

    private int id;

    private String title;

    private String attachment;

    private String content;

    private int auditStatus;

    private String createTime;

    private int createUserId;

    private String updateTime;

    private int updateUserId;

}
