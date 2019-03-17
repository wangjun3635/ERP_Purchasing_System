package com.team.purchasing.controller.response;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.utils.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "查询询价列表响应实体类")
@Data
public class QueryBargainListResponse extends GeneralResponse{

	@ApiModelProperty
	private List<Bargain> bargainList;
	
	@ApiModelProperty(value = "分页对象")
	private Page page;
}
