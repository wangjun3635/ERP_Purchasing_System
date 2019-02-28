package com.team.purchasing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.QueryBiddingListRequest;
import com.team.purchasing.mapper.BiddingDao;
import com.team.purchasing.service.BiddingService;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Autowired
	private BiddingDao bidingDao; 
	
	@Override
	public List<Bidding> queryBiddingList(QueryBiddingListRequest request) {
		
		List<Bidding> biddingList = bidingDao.queryBiddingList(request);
		
		return biddingList;
	}

	@Override
	public Long createBidding(OperateBiddingCmd cmd) {
		// 
		Long id = bidingDao.createBidding(cmd.getBidding());
		return id;
	}

}
