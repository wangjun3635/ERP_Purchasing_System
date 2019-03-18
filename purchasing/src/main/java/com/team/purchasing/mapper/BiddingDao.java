package com.team.purchasing.mapper;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingCommentRequest;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

public interface BiddingDao {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
	
	Integer countBiddingList(QueryBiddingListRequest request);
	
	List<Bidding> queryBiddingListForSupplier(QueryBiddingListRequest request);
	
	Integer countBiddingListForSupplier(QueryBiddingListRequest request);
	
	void createBiddingComment(OperateBiddingCommentCmd cmd);
	
	List<BiddingComment> queryBiddingCommentList(QueryBiddingCommentRequest request);
	
	Integer countBiddingCommentList(QueryBiddingCommentRequest request);
	
	void updateBiddingCommentSelected(OperateBiddingCommentCmd cmd);
	
	void updateBiddingCommentNotSelected(OperateBiddingCommentCmd cmd);
	
	
}
