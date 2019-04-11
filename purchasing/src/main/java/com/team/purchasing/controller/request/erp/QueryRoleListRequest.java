package com.team.purchasing.controller.request.erp;

import com.team.purchasing.common.GeneralRequest;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询角色请求实体类")
public class QueryRoleListRequest extends GeneralRequest {

	@ApiModelProperty(value = "主键id")
	private Long id;
	
	@ApiModelProperty(value = "角色类型[1：院校 2:晟誉]")
	private Integer type;
	
	@ApiModelProperty(value = "角色名称")
	private String name;
	
	@ApiModelProperty(value = "是否有效[0无效，1有效]")
	private Integer isValid;
	
	@ApiModelProperty(value = "分页信息")
	private Page page;
}
