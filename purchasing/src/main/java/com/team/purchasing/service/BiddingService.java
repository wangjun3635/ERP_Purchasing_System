package com.team.purchasing.service;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingCommentRequest;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

public interface BiddingService {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
	
	Integer countBiddingList(QueryBiddingListRequest request);
	
	List<Bidding> queryBiddingListForSupplier(QueryBiddingListRequest request);
	
	Integer countBiddingListForSupplier(QueryBiddingListRequest request);
	
	Long createBiddingComment(OperateBiddingCommentCmd cmd);
	
	List<BiddingComment> queryBiddingCommentList(QueryBiddingCommentRequest request);
	
	Integer countBiddingCommentList(QueryBiddingCommentRequest request);
	
	void updateBiddingComment(OperateBiddingCommentCmd cmd);
}
