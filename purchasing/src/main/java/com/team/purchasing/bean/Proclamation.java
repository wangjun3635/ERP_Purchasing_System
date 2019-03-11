package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:36
 */
@Data
public class Proclamation implements Serializable {

    private Integer id;

    private String title;

    private String attachment;

    private String content;

    private Integer auditStatus;

    private String createTime;

    private Integer createUserId;

    private String updateTime;

    private Integer updateUserId;

    private Page page;

}
