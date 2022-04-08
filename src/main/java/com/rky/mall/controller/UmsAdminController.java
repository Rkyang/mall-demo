package com.rky.mall.controller;

import com.rky.mall.common.api.CommonResult;
import com.rky.mall.dto.AdminLoginParam;
import com.rky.mall.mbg.model.UmsAdmin;
import com.rky.mall.mbg.model.UmsPermission;
import com.rky.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"后台用户管理"})
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @ApiOperation("后台用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("登录并返回token")
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(AdminLoginParam adminLoginParam, BindingResult bindingResult) {
        String token = adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword());
        if (token == null) {
            CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限和+-权限")
    @GetMapping("/getPermission")
    public CommonResult<List<UmsPermission>> getPermissionList(long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
