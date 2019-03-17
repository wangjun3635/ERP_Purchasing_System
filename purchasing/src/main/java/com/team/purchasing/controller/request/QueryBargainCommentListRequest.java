package com.team.purchasing.controller.request;

import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询询价回复请求实体类")
@Data
public class QueryBargainCommentListRequest extends GeneralRequest{

	@ApiModelProperty(value = "供应商id")
	private Long supplierId;
	
	@ApiModelProperty(value = "议价id")
	private Long bargainId;
	
}
