package com.team.purchasing.controller.request;

import com.team.purchasing.common.GeneralRequest;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询竞价请求实体类")
@Data
public class QueryBiddingCommentRequest extends GeneralRequest {

	@ApiModelProperty(value = "竞价id")
	private Long biddingId;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
}
