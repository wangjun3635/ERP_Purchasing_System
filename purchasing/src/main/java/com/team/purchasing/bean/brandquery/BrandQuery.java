package com.team.purchasing.bean.brandquery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/4/3 09:28
 * @Description:
 */
@Data
@ApiModel(value="品牌筛选条件实体")
public class BrandQuery<T> {

    @ApiModelProperty("返回的过滤条件key值")
    private String key;

    @ApiModelProperty("返回的过滤条件名称")
    private String name;

    @ApiModelProperty("返回的过滤条件")
    private List<T> responseList;

}
