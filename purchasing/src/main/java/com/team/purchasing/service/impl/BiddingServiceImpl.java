package com.team.purchasing.service.impl;

import com.team.purchasing.bean.Bidding;
import com.team.purchasing.bean.BiddingComment;
import com.team.purchasing.bean.BiddingSupplierCategory;
import com.team.purchasing.controller.request.OperateBiddingCmd;
import com.team.purchasing.controller.request.OperateBiddingCommentCmd;
import com.team.purchasing.controller.request.QueryBiddingCommentRequest;
import com.team.purchasing.controller.request.QueryBiddingListRequest;
import com.team.purchasing.mapper.BiddingDao;
import com.team.purchasing.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Autowired(required = false)
	private BiddingDao bidingDao;
	
	@Override
	public List<Bidding> queryBiddingList(QueryBiddingListRequest request) {
		
		List<Bidding> biddingList = bidingDao.queryBiddingList(request);
		
		return biddingList;
	}

	@Override
	public Long createBidding(OperateBiddingCmd cmd) {
		Long id = bidingDao.createBidding(cmd);
		
		BiddingSupplierCategory biddingSupplierCategory = new BiddingSupplierCategory();
		
		biddingSupplierCategory.setBiddingId(id);
		biddingSupplierCategory.setCategoryIdList(cmd.getBidding().getSupplierCategoryList());
		bidingDao.createBiddingSupplierCategory(biddingSupplierCategory);
		
		return id;
	}
	
	@Override
	public Integer countBiddingList(QueryBiddingListRequest request) {
		Integer count = bidingDao.countBiddingList(request);
		return count;
	}
	
	@Override
	public Integer countBiddingListForSupplier(QueryBiddingListRequest request) {
		Integer count = bidingDao.countBiddingListForSupplier(request);
		return count;
	}
	
	@Override
	public List<Bidding> queryBiddingListForSupplier(QueryBiddingListRequest request) {
		List<Bidding> biddingList = bidingDao.queryBiddingListForSupplier(request);
		return biddingList;
	}
	
	@Override
	public Long createBiddingComment(OperateBiddingCommentCmd cmd) {
		Long id = bidingDao.createBiddingComment(cmd);
		return id;
	}

	@Override
	public List<BiddingComment> queryBiddingCommentList(QueryBiddingCommentRequest request) {
		
		List<BiddingComment> list = bidingDao.queryBiddingCommentList(request);
		
		return list;
	}

	@Override
	public Integer countBiddingCommentList(QueryBiddingCommentRequest request) {
		
		Integer count = bidingDao.countBiddingCommentList(request);
		
		return count;
	}
	
	@Override
	public void updateBiddingComment(OperateBiddingCommentCmd cmd) {
		
		bidingDao.updateBiddingCommentSelected(cmd);
		bidingDao.updateBiddingCommentSelected(cmd);
		
	}
	
}
