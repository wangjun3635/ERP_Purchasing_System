package com.team.purchasing.controller.request;

import com.team.purchasing.bean.BargainComment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "竞价回复操作类")
@Data
public class BargainCommentCmd {

	@ApiModelProperty
	private BargainComment bargainComment;
}
