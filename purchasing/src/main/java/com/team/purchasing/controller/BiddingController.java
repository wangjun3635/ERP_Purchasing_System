package com.team.purchasing.controller;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.common.GeneralResponse;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.QueryBiddingListRequest;
import com.team.purchasing.controller.response.QueryBiddingListResponse;
import com.team.purchasing.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BiddingController {

	@Autowired
	private BiddingService biddingService; 
	
	public QueryBiddingListResponse queryBiddingList(QueryBiddingListRequest request) {
		
		QueryBiddingListResponse response = new QueryBiddingListResponse(); 
		List<Bidding> biddingList = biddingService.queryBiddingList(request);
		response.setBiddingList(biddingList);
		return response;
	}
	
	public GeneralResponse createBidding(OperateBiddingCmd cmd) {
		GeneralResponse response = new GeneralResponse();
		
		Long id = biddingService.createBidding(cmd);
		
		response.getMessageInfo().setKey(id+"");
		return response;
	}
	
}
