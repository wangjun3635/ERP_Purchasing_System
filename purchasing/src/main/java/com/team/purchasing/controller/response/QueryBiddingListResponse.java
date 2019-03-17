package com.team.purchasing.controller.response;

import java.util.List;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "查询竞价响应实体类")
public class QueryBiddingListResponse extends GeneralResponse {

	@ApiModelProperty
	private List<Bidding> biddingList;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
}
