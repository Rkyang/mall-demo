package com.rky.mall.controller;

import com.rky.mall.common.api.CommonPage;
import com.rky.mall.common.api.CommonResult;
import com.rky.mall.mbg.model.PmsBrand;
import com.rky.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"品牌管理"})
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("获取全部品牌")
    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("新增品牌")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult<PmsBrand> createBrand(PmsBrand pmsBrand) {
        int result = pmsBrandService.createBrand(pmsBrand);
        if (result > 0) {
            LOGGER.info("createBrand success:{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            LOGGER.info("createBrand failed:{}", pmsBrand);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("更新品牌")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult<PmsBrand> updateBrand(PmsBrand pmsBrand) {
        int result = pmsBrandService.updateBrand(pmsBrand);
        if (result > 0) {
            LOGGER.info("updateBrand success:{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            LOGGER.info("updateBrand failed:{}", pmsBrand);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("删除品牌")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult<String> deleteBrand(long id) {
        int result = pmsBrandService.deleteBrand(id);
        if (result > 0) {
            LOGGER.info("deleteBrand success, id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.info("deleteBrand failed, id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页获取品牌")
    @GetMapping("/listBrand")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> listBrand(int pageNum, int pageSize) {
        List<PmsBrand> pmsBrands = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrands));
    }

    @ApiOperation("根据id获取品牌")
    @GetMapping("/getBrand")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<PmsBrand> getBrand(long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
