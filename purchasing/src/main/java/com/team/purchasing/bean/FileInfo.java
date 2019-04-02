package com.team.purchasing.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/4/2 11:07
 * @Description:
 */
@Data
@ApiModel(value="文件类实体")
public class FileInfo {

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "文件访问URL")
    private String url;

}
