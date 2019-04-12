package com.team.purchasing.controller.response.erp;

import java.util.List;

import com.team.purchasing.bean.erp.Privilege;
import com.team.purchasing.common.GeneralResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询权限响应实体类")
public class queryPrivilegeResponse extends GeneralResponse {

	@ApiModelProperty(value = "权限集合")
	private List<Privilege> privilegeList;
}
