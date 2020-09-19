package com.chw.test.dao;

import com.chw.test.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> getAllUser();

}
