package com.team.purchasing.service;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

public interface BiddingService {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
}
