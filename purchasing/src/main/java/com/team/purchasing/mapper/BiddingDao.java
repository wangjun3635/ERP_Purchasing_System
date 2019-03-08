package com.team.purchasing.mapper;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

import java.util.List;

public interface BiddingDao {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(Bidding bidding);
}
