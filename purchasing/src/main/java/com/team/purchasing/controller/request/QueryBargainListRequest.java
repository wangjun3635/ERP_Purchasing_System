package com.team.purchasing.controller.request;

import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "议价请求实体类")
public class QueryBargainListRequest extends GeneralRequest {

	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "医院学校id")
	private Long hsId;
	
	@ApiModelProperty(value = "用户id")
	private Long userId;
	
	
}
