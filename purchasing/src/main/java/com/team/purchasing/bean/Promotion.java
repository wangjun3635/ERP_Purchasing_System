package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:19/2/19 下午9:28
 */
@Data
@ApiModel(value="促销实体")
public class Promotion implements Serializable {

    @ApiModelProperty(value = "促销id")
    private Integer id;

    @ApiModelProperty(value = "促销标题")
    private String title;

    @ApiModelProperty(value = "促销图片")
    private String attachmentImg;

    @ApiModelProperty(value = "促销内容")
    private String content;
    
    @ApiModelProperty(value = "是否有效,0无效,1有效")
    private Integer isvalid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户")
    private Integer createUserId;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "更新用户")
    private Integer updateUserId;

    @ApiModelProperty(value = "分页")
    private Page page;

}
