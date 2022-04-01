package com.rky.mall.controller;

import com.rky.mall.common.api.CommonPage;
import com.rky.mall.common.api.CommonResult;
import com.rky.mall.mbg.model.CmsHelp;
import com.rky.mall.service.CmsHelpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/help")
public class CmsHelpController {

    @Autowired
    private CmsHelpService cmsHelpService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsHelpController.class);

    @GetMapping("/listAll")
    public CommonResult<List<CmsHelp>> getHelpList() {
        return CommonResult.success(cmsHelpService.listAllHelp());
    }

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

    @GetMapping("/listHelp")
    public CommonResult<CommonPage<CmsHelp>> listHelp(int pageNum, int pageSize) {
        List<CmsHelp> cmsHelps = cmsHelpService.listHelp(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(cmsHelps));
    }

    @GetMapping("/get")
    public CommonResult<CmsHelp> getHelp(long id) {
        return CommonResult.success(cmsHelpService.getHelp(id));
    }
}
