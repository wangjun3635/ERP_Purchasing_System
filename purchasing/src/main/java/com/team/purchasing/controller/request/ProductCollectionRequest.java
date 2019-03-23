package com.team.purchasing.controller.request;

import com.team.purchasing.bean.ProductCollection;
import com.team.purchasing.common.GeneralRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:39
 * @Description:
 */
@Data
@ApiModel(description = "产品收藏夹请求实体类")
public class ProductCollectionRequest extends GeneralRequest {

    @ApiModelProperty(value = "产品收藏夹")
    private ProductCollection productCollection;

}
