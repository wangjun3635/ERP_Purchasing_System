package com.team.purchasing.controller.request.erp;

import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询权限请求实体类")
public class QueryPrivilegeRequest extends GeneralRequest {

	@ApiModelProperty(value = "权限名称")
	private String name;
	
	@ApiModelProperty(value = "权限id")
	private Long id;
	
	@ApiModelProperty(value = "是否有效[1：有效  0：无效]")
	private Integer isValid;
}
