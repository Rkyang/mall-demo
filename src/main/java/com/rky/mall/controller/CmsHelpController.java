package com.rky.mall.controller;

import com.rky.mall.common.api.CommonPage;
import com.rky.mall.common.api.CommonResult;
import com.rky.mall.mbg.model.CmsHelp;
import com.rky.mall.service.CmsHelpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"帮助数据管理"})
@RestController
@RequestMapping("/help")
public class CmsHelpController {

    @Autowired
    private CmsHelpService cmsHelpService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsHelpController.class);

    @ApiOperation("获取所有帮助数据")
    @GetMapping("/listAll")
    public CommonResult<List<CmsHelp>> getHelpList() {
        return CommonResult.success(cmsHelpService.listAllHelp());
    }

    @ApiOperation("新增一条帮助数据")
    @PostMapping("/create")
    public CommonResult<CmsHelp> createHelp(CmsHelp cmsHelp) {
        CommonResult<CmsHelp> commonResult;
        int result = cmsHelpService.createHelp(cmsHelp);
        if (result == 1) {
            commonResult = CommonResult.success(cmsHelp);
            LOGGER.debug("createHelp success:{}", cmsHelp);
        } else {
            commonResult = CommonResult.failed("新增失败");
            LOGGER.debug("createHelp failed:{}", cmsHelp);
        }
        return commonResult;
    }

    @ApiOperation("更新一条帮助数据")
    @PutMapping("/update")
    public CommonResult<CmsHelp> updateHelp(CmsHelp cmsHelp) {
        CommonResult<CmsHelp> commonResult;
        int result = cmsHelpService.updateHelp(cmsHelp);
        if (result == 1) {
            commonResult = CommonResult.success(cmsHelp);
            LOGGER.debug("updateHelp success:{}", cmsHelp);
        } else {
            commonResult = CommonResult.failed("更新失败");
            LOGGER.debug("updateHelp failed:{}", cmsHelp);
        }
        return commonResult;
    }

    @ApiOperation("删除一条帮助数据")
    @DeleteMapping("/delete")
    public CommonResult<String> deleteHelp(long id) {
        int result = cmsHelpService.deleteHelp(id);
        if (result == 1) {
            LOGGER.debug("deleteHelp success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteHelp failed :id={}", id);
            return CommonResult.failed("删除失败");
        }
    }

    @ApiOperation("分页查询帮助数据")
    @GetMapping("/listHelp")
    public CommonResult<CommonPage<CmsHelp>> listHelp(@ApiParam("页码") int pageNum, @ApiParam("条数") int pageSize) {
        List<CmsHelp> cmsHelps = cmsHelpService.listHelp(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(cmsHelps));
    }

    @ApiOperation("根据id获取一条帮助数据")
    @GetMapping("/get")
    public CommonResult<CmsHelp> getHelp(long id) {
        return CommonResult.success(cmsHelpService.getHelp(id));
    }
}
