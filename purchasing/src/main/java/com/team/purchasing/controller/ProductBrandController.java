package com.team.purchasing.controller;

import com.team.purchasing.bean.ProductBrand;
import com.team.purchasing.controller.request.ProductBrandRequest;
import com.team.purchasing.controller.response.ProductBrandResponse;
import com.team.purchasing.service.ProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther:ynhuang
 * @Date:19/3/19 下午9:48
 */
@RestController
@RequestMapping("/productBrand")
@Api(tags="品牌查询接口")
@Slf4j
public class ProductBrandController {

    @Resource
    private ProductBrandService productBrandService;

    @PostMapping("/queryProductBrandList")
    @ApiOperation(value="品牌信息查询", notes = "品牌信息查询")
    public ProductBrandResponse queryProductBrandList(@RequestBody ProductBrandRequest request) {

        ProductBrand productBrand = request.getProductBrand();

        //1 更新page
        Integer count = productBrandService.queryProductBrandCount(productBrand);

        productBrand.getPage().init(count);

        //2 查询数据
        List<ProductBrand> productBrands = productBrandService.queryProductBrandList(productBrand);

        //4 拼接参数
        ProductBrandResponse productBrandResponse = new ProductBrandResponse();
        productBrandResponse.setProductBrands(productBrands);
        productBrandResponse.setPage(productBrand.getPage());

        return productBrandResponse;
    }

}
