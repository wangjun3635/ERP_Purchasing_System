package com.team.purchasing.common;

import org.springframework.util.StringUtils;

public class PaginationDTO {

	private String currentPage;
	
	private String pageSize;
	
	private String totalCount;

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	

	public String getStart(){
		if(!StringUtils.isEmpty(this.currentPage) && !StringUtils.isEmpty(this.pageSize)){
			return String.valueOf((Integer.parseInt(this.currentPage) - 1) * Integer.parseInt(this.pageSize));
		}
		return null;
	}
	
	public String getEnd(){
		if(getStart() != null){
			return String.valueOf(Integer.parseInt(getStart())+Integer.parseInt(this.pageSize));
		}
		return null;
	}
}
