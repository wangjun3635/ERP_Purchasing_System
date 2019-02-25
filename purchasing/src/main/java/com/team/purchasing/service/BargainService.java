package com.team.purchasing.service;

import java.util.List;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.controller.request.QueryBargainListRequest;

public interface BargainService {

	public Long createBargain(Bargain bargain);
	
	public List<Bargain> queryBargainList(QueryBargainListRequest request);
	
	public Long countBargainList(QueryBargainListRequest request);
}
