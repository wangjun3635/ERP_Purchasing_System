package com.team.purchasing.controller.request.erp;

import com.team.purchasing.bean.Role;
import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色操作请求实体类")
public class OperateRoleCmd extends GeneralRequest {
	
	@ApiModelProperty(value = "角色")
	private Role role;

}
