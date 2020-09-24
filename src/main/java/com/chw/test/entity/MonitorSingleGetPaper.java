package com.chw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.chw.test.dto.DruidUrlMonitorContentJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MonitorSingleGetPaper extends Model<MonitorSingleGetPaper> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer requestCount;

    private Long requestTimeMillis;

    private Integer requestTimeMillisMax;

    private LocalDateTime requestTimeMillisMaxOccurTime;

    private LocalDateTime lastAccessTime;

    private Integer concurrentMax;

    private Integer jdbcExecuteCount;

    private Integer jdbcExecutePeak;

    private Long jdbcExecuteTimeMillis;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public static MonitorSingleGetPaper getBean(DruidUrlMonitorContentJson content) {
        MonitorSingleGetPaper monitorSingleGetPaper = new MonitorSingleGetPaper();
        monitorSingleGetPaper.setRequestCount(content.getRequestCount());
        monitorSingleGetPaper.setRequestTimeMillis(content.getRequestTimeMillis());
        monitorSingleGetPaper.setRequestTimeMillisMax(content.getRequestTimeMillisMax());
        monitorSingleGetPaper.setRequestTimeMillisMaxOccurTime(content.getRequestTimeMillisMaxOccurTime());
        monitorSingleGetPaper.setConcurrentMax(content.getConcurrentMax());
        monitorSingleGetPaper.setLastAccessTime(content.getLastAccessTime());
        monitorSingleGetPaper.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorSingleGetPaper.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        monitorSingleGetPaper.setJdbcExecutePeak(content.getJdbcExecutePeak());
        return monitorSingleGetPaper;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
