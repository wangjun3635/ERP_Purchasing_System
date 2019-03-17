package com.team.purchasing.controller.request;

import com.team.purchasing.common.GeneralRequest;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询询价请求实体类")
@Data
public class QueryBargainListRequest extends GeneralRequest {

	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "医院学校id")
	private Long hsId;
	
	@ApiModelProperty(value = "用户id")
	private Long userId;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
	
}
