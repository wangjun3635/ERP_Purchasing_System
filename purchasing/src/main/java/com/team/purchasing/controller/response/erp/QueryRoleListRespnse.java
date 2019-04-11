package com.team.purchasing.controller.response.erp;

import java.util.List;

import com.team.purchasing.bean.Role;
import com.team.purchasing.common.GeneralResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询角色响应实体类")
public class QueryRoleListRespnse extends GeneralResponse {

	@ApiModelProperty(value = "角色列表")
	private List<Role> roleList;
}
