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
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MonitorUnionGetPaper extends Model<MonitorUnionGetPaper> {

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

    public static MonitorUnionGetPaper getBean(DruidUrlMonitorContentJson content) {
        MonitorUnionGetPaper monitorUnionGetPaper = new MonitorUnionGetPaper();
        monitorUnionGetPaper.setRequestCount(content.getRequestCount());
        monitorUnionGetPaper.setRequestTimeMillis(content.getRequestTimeMillis());
        monitorUnionGetPaper.setRequestTimeMillisMax(content.getRequestTimeMillisMax());
        monitorUnionGetPaper.setRequestTimeMillisMaxOccurTime(content.getRequestTimeMillisMaxOccurTime());
        monitorUnionGetPaper.setConcurrentMax(content.getConcurrentMax());
        monitorUnionGetPaper.setLastAccessTime(content.getLastAccessTime());
        monitorUnionGetPaper.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorUnionGetPaper.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        monitorUnionGetPaper.setJdbcExecutePeak(content.getJdbcExecutePeak());
        return monitorUnionGetPaper;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
