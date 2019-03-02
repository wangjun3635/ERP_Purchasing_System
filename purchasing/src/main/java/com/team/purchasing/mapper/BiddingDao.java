package com.team.purchasing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.QueryBiddingListRequest;

public interface BiddingDao {

	List<Bidding> queryBiddingList(QueryBiddingListRequest request);
	
	Long createBidding(Bidding bidding);
}
