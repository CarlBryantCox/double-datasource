package com.chw.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chw.test.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> getAllUser();

    String saveUser(Integer id);
}
