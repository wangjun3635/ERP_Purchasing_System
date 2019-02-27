package com.team.purchasing.controller.response;

import java.util.List;

import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.common.GeneralResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "查询竞价回复实体类")
@Data
public class QueryBargainCommentListResponse extends GeneralResponse{

	@ApiModelProperty
	private List<BargainComment> list;
}
