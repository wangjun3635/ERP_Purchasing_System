package com.team.purchasing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.bean.BargainComment;
import com.team.purchasing.controller.request.BargainCommentCmd;
import com.team.purchasing.controller.request.OperateBargainCmd;
import com.team.purchasing.controller.request.QueryBargainCommentListRequest;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import com.team.purchasing.mapper.BargainDao;
import com.team.purchasing.service.BargainService;

@Service
public class BargainServiceImpl implements BargainService {

	@Autowired
	private BargainDao bargainDao;
	
	@Override
	public Long createBargain(OperateBargainCmd cmd) {
		bargainDao.createBargain(cmd);
		return cmd.getBargain().getId();
	}

	@Override
	public List<Bargain> queryBargainList(QueryBargainListRequest request) {
		List<Bargain> list =  bargainDao.queryBargainList(request);
		return list;
	}

	@Override
	public Long countBargainList(QueryBargainListRequest request) {
		Long count = bargainDao.countBargainList(request);
		return count;
	}

	@Override
	public Long createBargainComment(BargainCommentCmd cmd) {
		
		bargainDao.createBargainComment(cmd);
		return cmd.getBargainComment().getId();
	}
	
	@Override
	public List<BargainComment> queryBargainCommentList(QueryBargainCommentListRequest request) {
		 
		List<BargainComment> list = bargainDao.queryBargainCommentList(request);
		
		return list;
	}
}
