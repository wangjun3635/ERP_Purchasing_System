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
    @Getter
    @Setter
    @ApiModelProperty(value = "记录总数")
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

    //数据库分页所取到的数据
    @Getter
    @ApiModelProperty(value = "数据库分页所取到的数据")
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
