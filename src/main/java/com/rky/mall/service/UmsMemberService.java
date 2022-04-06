package com.rky.mall.service;

import com.rky.mall.common.api.CommonResult;

/**
 * 会员管理
 * @date 2022/4/6
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone 手机号
     */
    CommonResult<String> generateAuthCode(String telephone);

    /**
     * 验证手机号和手机号码是否匹配
     * @param telephone 手机号
     * @param authCode 验证码
     */
    CommonResult<String> verifyAuthCode(String telephone, String authCode);
}
