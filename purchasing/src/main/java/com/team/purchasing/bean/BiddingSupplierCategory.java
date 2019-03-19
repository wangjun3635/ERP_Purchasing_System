package com.team.purchasing.bean;

import java.util.List;

import lombok.Data;

@Data
public class BiddingSupplierCategory {

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 竞价id
	 */
	private Long biddingId;
	
	/**
	 * 分类id
	 */
	private List<Integer> categoryIdList;
	
	/**
	 * 分类名称
	 */
	private String categoryName;
}
