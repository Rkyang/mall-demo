package com.rky.mall.controller;

import com.rky.mall.common.api.CommonResult;
import com.rky.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"会员登录注册管理"})
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult<String> getAuthCode(String telephone) {
        if (ObjectUtils.isEmpty(telephone)) {
            return CommonResult.failed("请输入手机号");
        }
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证验证码")
    @GetMapping("/verifyAuthCode")
    public CommonResult<String> verifyAuthCode(String telephone, String authCode) {
        if (ObjectUtils.isEmpty(telephone)) {
            return CommonResult.failed("请输入手机号");
        }
        if (ObjectUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
