package com.team.purchasing.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.purchasing.bean.Bargain;
import com.team.purchasing.controller.request.QueryBargainListRequest;

@Mapper
public interface BargainDao {

	public Long createBargain(Bargain bargain);
	
	public List<Bargain> queryBargainList(QueryBargainListRequest request);
	
	public Long countBargainList(QueryBargainListRequest request);
}
