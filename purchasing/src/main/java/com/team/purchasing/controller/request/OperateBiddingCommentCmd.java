package com.team.purchasing.controller.request;

import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.common.GeneralRequest;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description = "添加或者修改竞价回复")
@Data
public class OperateBiddingCommentCmd extends GeneralRequest {

	private BiddingComment biddingComment;
}
