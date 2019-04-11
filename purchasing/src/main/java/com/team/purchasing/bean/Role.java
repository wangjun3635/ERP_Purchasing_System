package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色")
public class Role {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "角色类型[1：院校 2:晟誉]")
	private Integer type;
	
	@ApiModelProperty(value = "角色名称")
	private String name;
	
	@ApiModelProperty(value = "备注说明")
	private String remark;
	
	@ApiModelProperty(value = "删除标志[0未删除，1删除]")
	private Integer isValid;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "创建人")
	private Long createUserId;
	
	@ApiModelProperty(value = "最近更新时间")
	private String updateTime;	
	
	@ApiModelProperty(value = "最近更新人")
	private Long updateUserId;
}
