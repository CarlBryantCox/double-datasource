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
public class MonitorUnionAll extends Model<MonitorUnionAll> {

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

    public static MonitorUnionAll getBean(DruidUrlMonitorContentJson content) {
        MonitorUnionAll monitorUnionAll = new MonitorUnionAll();
        monitorUnionAll.setRequestCount(content.getRequestCount());
        monitorUnionAll.setConcurrentMax(content.getConcurrentMax());
        monitorUnionAll.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorUnionAll.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        return monitorUnionAll;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
