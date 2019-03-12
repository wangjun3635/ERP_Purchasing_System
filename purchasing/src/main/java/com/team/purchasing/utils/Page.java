package com.team.purchasing.utils;

import lombok.Getter;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:18
 */
public class Page {

    //总数据
    @Getter
    private Integer total;

    //当前是第几页
    @Getter
    private Integer currentPage;

    //当前一页显示多少数据
    @Getter
    private Integer currentNum;

    //数据库分页所取到的数据
    @Getter
    private Integer rowNumber;

    public void setRowNumber(){
        this.rowNumber = this.currentNum * (currentPage - 1);
    }

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

        this.rowNumber = this.currentNum * (currentPage - 1);
    }

}
