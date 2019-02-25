package com.team.purchasing.controller.response;

import java.util.List;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.common.GeneralResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询询价列表响应实体类")
@Data
public class QueryBargainListResponse extends GeneralResponse{

	@ApiModelProperty
	private List<Bargain> bargainList;
}
