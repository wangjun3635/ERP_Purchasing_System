package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:ynhuang
 * @Date:24/2/19 下午3:57
 * 产品类别表
 */
@Data
@ApiModel(value="产品类型实体")
public class ProductCategory implements Serializable {

    @ApiModelProperty(value = "产品类型id")
    private Integer id;

    @ApiModelProperty(value = "产品类型name")
    private String name;

    @ApiModelProperty(value = "级别")
    private String level;

    @ApiModelProperty(value = "父级别id")
    private String parentId;

    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建用户")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

    @ApiModelProperty(value = "更新用户")
    private Long updateUserId;

}
