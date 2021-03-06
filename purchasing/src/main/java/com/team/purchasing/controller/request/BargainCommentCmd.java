package com.team.purchasing.controller.request;

import javax.validation.constraints.NotNull;

import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "询价回复操作类")
@Data
public class BargainCommentCmd extends GeneralRequest{

	@NotNull
	@ApiModelProperty
	private BargainComment bargainComment;
}
