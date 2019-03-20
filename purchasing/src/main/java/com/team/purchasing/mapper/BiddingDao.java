package com.team.purchasing.mapper;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.bean.BiddingSupplierCategory;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingCommentRequest;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BiddingDao {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
	
	void createBiddingSupplierCategory(BiddingSupplierCategory biddingSupplierCategory);
	
	Integer countBiddingList(QueryBiddingListRequest request);
	
	List<Bidding> queryBiddingListForSupplier(QueryBiddingListRequest request);
	
	Integer countBiddingListForSupplier(QueryBiddingListRequest request);
	
	Long createBiddingComment(OperateBiddingCommentCmd cmd);
	
	List<BiddingComment> queryBiddingCommentList(QueryBiddingCommentRequest request);
	
	Integer countBiddingCommentList(QueryBiddingCommentRequest request);
	
	void updateBiddingCommentSelected(OperateBiddingCommentCmd cmd);
	
	void updateBiddingCommentNotSelected(OperateBiddingCommentCmd cmd);
	
	List<BiddingSupplierCategory> queryBiddingSupplierCategory(Long biddingId);
}
