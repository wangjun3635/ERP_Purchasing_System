package com.team.purchasing.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:18
 */
public class Page {

    //总数据
    @Getter
    @Setter
    private int total;

    //当前是第几页
    @Getter
    @Setter
    private int currentPage;

    //当前一页显示多少数据
    @Getter
    @Setter
    private int currentNum;

    private int rowNumber;

    public Page(){
        this.rowNumber = this.currentNum * (currentPage - 1);
    }

}
