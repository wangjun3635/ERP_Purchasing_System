package com.team.purchasing.service;

import java.util.List;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

public interface BiddingService {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(OperateBiddingCmd cmd);
}
