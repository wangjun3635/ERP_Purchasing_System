package com.team.purchasing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.controller.request.QueryBargainListRequest;
import com.team.purchasing.mapper.BargainDao;
import com.team.purchasing.service.BargainService;

@Service
public class BargainServiceImpl implements BargainService {

	@Autowired
	private BargainDao bargainDao;
	
	@Override
	public Long createBargain(Bargain bargain) {
		Long id = bargainDao.createBargain(bargain);
		return id;
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

	
}
