package com.team.purchasing.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @Auther:ynhuang
 * @Date:23/2/19 下午5:18
 */
public class Page {

    //总数据
    @Getter
    @ApiModelProperty(value = "总数据大小，前台无需传，后台查询获取返回")
    private Integer total;

    //当前是第几页
    @Getter
    @NotNull
    @ApiModelProperty(value = "当前为第几页，前台需传")
    private Integer currentPage;

    //当前一页显示多少数据
    @Getter
    @ApiModelProperty(value = "当前一页显示多少数据，前台需传，不传后台有固定值20")
    private Integer currentNum;

    //数据库分页所取到的数据
    @Getter
    @ApiModelProperty(value = "此参数前台不用管")
    private Integer rowNumber;

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

        if(currentPage == null || currentPage == 0){
            this.currentPage = 20;
        }

        this.rowNumber = this.currentNum * (currentPage - 1);
    }

}
