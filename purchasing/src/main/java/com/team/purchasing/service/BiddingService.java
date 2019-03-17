package com.team.purchasing.service;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

public interface BiddingService {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
	
	Integer countBiddingList(QueryBiddingListRequest request);
	
	List<Bidding> queryBiddingListForSupplier(QueryBiddingListRequest request);
	
	Integer countBiddingListForSupplier(QueryBiddingListRequest request);
	
	void createBiddingComment(OperateBiddingCommentCmd cmd);
}
