package com.rky.mall.controller;

import com.rky.mall.common.api.CommonPage;
import com.rky.mall.common.api.CommonResult;
import com.rky.mall.nosql.es.document.EsProduct;
import com.rky.mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理Controller
 * @date 2022/4/15
 */
@Api(tags = {"搜索商品管理"})
@RestController
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService productService;

    @ApiOperation("导入所有数据库中的商品到ES")
    @PostMapping("/importAll")
    public CommonResult<Integer> importAll() {
        return CommonResult.success(productService.importAll());
    }

    @ApiOperation("根据id删除商品")
    @DeleteMapping("/delete")
    public CommonResult<String> delete(Long id) {
        productService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation("根据id批量删除商品")
    @DeleteMapping("/batchDelete")
    public CommonResult<String> delete(List<Long> id) {
        productService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation("根据id创建商品")
    @PostMapping("/create")
    public CommonResult<EsProduct> create(Long id) {
        EsProduct product = productService.create(id);
        if (product != null) {
            return CommonResult.success(product);
        }
        return CommonResult.failed();
    }

    @ApiOperation("简单搜索")
    @GetMapping("/search/simple")
    public CommonResult<CommonPage<EsProduct>> search(String keyword, int pageNum, int pageSize) {
        Page<EsProduct> search = productService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(search));
    }
}
