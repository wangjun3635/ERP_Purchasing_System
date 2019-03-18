package com.team.purchasing.controller.response;


import java.util.List;

import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询竞价响应实体类")
@Data
public class QueryBiddingCommentResponse extends GeneralResponse {

	@ApiModelProperty
	private List<BiddingComment> biddingCommentList;
	
	@ApiModelProperty(value ="分页对象")
	private Page page;
}
