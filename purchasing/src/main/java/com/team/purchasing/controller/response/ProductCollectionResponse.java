package com.team.purchasing.controller.response;

import com.team.purchasing.bean.ProductCollection;
import com.team.purchasing.common.GeneralResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: 018399
 * @Date: 2019/3/23 14:41
 * @Description:
 */
@Data
@ApiModel(description = "产品收藏夹响应实体类")
public class ProductCollectionResponse extends GeneralResponse {

    @ApiModelProperty
    private List<ProductCollection> productCollections;

}
