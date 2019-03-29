package com.team.purchasing.bean;

import com.team.purchasing.utils.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:36
 */
@Data
@ApiModel(value="公告实体")
public class Proclamation implements Serializable {

    @ApiModelProperty(value = "公告id")
    private Integer id;

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "附件")
    private String attachment;

    @ApiModelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "审批状态,1代表审批，2代表未审批")
    private Integer auditStatus;

    @ApiModelProperty(value = "是否有效 0：无效 1：有效")
    private Integer isValid;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建人")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "更新人")
    private Long updateUserId;

    @ApiModelProperty(value = "分页")
    private Page page;

}
