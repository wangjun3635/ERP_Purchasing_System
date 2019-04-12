package com.team.purchasing.controller.request.erp;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "操作权限请求实体类")
public class OperatePrivilegeCmd extends GeneralRequest {

	@ApiModelProperty(value = "权限对象")
	private Privilege privilege; 
}
