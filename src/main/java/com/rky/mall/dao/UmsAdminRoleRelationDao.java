package com.rky.mall.dao;

import com.rky.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台用户与角色管理自定义dao
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限和+-权限
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
