package com.team.purchasing.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:18
 */
@ApiModel(description = "分页对象")
public class Page {

    //总数据
    @ApiModelProperty(value = "记录总数")
    @Getter
    @Setter
    private Integer total;

    //当前是第几页
    @Getter
    @Setter
    @ApiModelProperty(value = "当前第几页")
    private Integer currentPage;

	//当前一页显示多少数据
    @Getter
    @Setter
    @ApiModelProperty(value = "当前一页显示多少数据")
    private Integer currentNum;
    
    @Getter
    @Setter
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;

	//数据库分页所取到的数据
    @Getter
    @Setter
    @ApiModelProperty(value = "数据库分页所取到的数据")
    private Integer rowNumber;

    
    public Page() {
  	}

  	public Page(Integer currentPage, Integer currentNum) {
  		this.currentPage = currentPage;
  		this.currentNum = currentNum;
  	}

    
//    public void setRowNumber(){
//        this.rowNumber = this.currentNum * (currentPage - 1);
//    }

    /**
     * 初始化分页信息
     * @param total
     */
    public void init(Integer total){

        if(total != null){
            this.total = total;
        }else {
            this.total = 0;
        }

        if(currentNum == null || currentNum == 0){
            this.currentNum = 20;
        }

        if(currentPage == null || currentPage == 0){
            this.currentPage = 1;
        }

        this.rowNumber = this.currentNum * (currentPage - 1);
        this.totalPage = total % currentNum == 0 ? total / currentNum : total / currentNum + 1;
    }


    
//    public Integer getTotal() {
//		return total;
//	}
//
//	public void setTotal(Integer total) {
//		this.total = total;
//		this.totalPage = total/this.currentNum + 1;
//	}

}

