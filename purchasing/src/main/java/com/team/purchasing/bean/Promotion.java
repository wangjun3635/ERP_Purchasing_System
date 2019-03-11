package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:28
 */
@Data
public class Promotion implements Serializable {

    private Integer id;

    private String title;

    private String attachmentImg;

    private String content;

    private String createTime;

    private Integer createUserId;

    private String updateTime;

    private Integer updateUserId;

    private Page page;

}
