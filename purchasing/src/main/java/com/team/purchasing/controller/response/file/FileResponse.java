package com.team.purchasing.controller.response.file;

import com.team.purchasing.bean.FileInfo;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/4/2 11:06
 * @Description:
 */
@Data
@ApiModel(description = "文件上传返回信息实体类")
public class FileResponse extends GeneralResponse {

    @ApiModelProperty
    private FileInfo fileInfo;
}
