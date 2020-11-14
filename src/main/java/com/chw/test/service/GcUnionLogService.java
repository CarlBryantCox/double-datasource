package com.chw.test.service;

import com.chw.test.entity.GcUnionLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChenWei
 * @since 2020-11-14
 */
public interface GcUnionLogService extends IService<GcUnionLog> {

    void saveGcLog();

}
