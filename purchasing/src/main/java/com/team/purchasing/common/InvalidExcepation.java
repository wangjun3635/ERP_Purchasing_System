package com.team.purchasing.common;

import lombok.Data;


@Data
public class InvalidExcepation extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String errMsg;
	
	public InvalidExcepation(String code,String errMsg) {
		super(errMsg);
		this.code = code;
	}

}
