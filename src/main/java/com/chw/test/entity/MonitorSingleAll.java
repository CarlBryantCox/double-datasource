package com.chw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.chw.test.dto.DruidUrlMonitorContentJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MonitorSingleAll extends Model<MonitorSingleAll> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer requestCount;

    private Integer concurrentMax;

    private Integer jdbcExecuteCount;

    private Long jdbcExecuteTimeMillis;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public static MonitorSingleAll getBean(DruidUrlMonitorContentJson content) {
        MonitorSingleAll monitorSingleAll = new MonitorSingleAll();
        monitorSingleAll.setRequestCount(content.getRequestCount());
        monitorSingleAll.setConcurrentMax(content.getConcurrentMax());
        monitorSingleAll.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorSingleAll.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        return monitorSingleAll;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
