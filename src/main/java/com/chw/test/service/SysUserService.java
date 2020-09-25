package com.chw.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chw.test.entity.*;

import java.util.List;
import java.util.Map;

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

    Map<String,Object> getRecord(Integer size);

    List<RecordSingleGetPaper> singleGetPaper(Integer size);

    List<RecordSingleSubmitScore> singleSubmitScore(Integer size);

    List<RecordSingleAll> singleAll(Integer size);

    List<RecordUnionGetPaper> unionGetPaper(Integer size);

    List<RecordUnionSubmitScore> unionSubmitScore(Integer size);

    List<RecordUnionAll> unionAll(Integer size);
}
