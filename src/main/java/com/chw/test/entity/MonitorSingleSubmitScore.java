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
public class MonitorSingleSubmitScore extends Model<MonitorSingleSubmitScore> {

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

    private String histogram;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public static MonitorSingleSubmitScore getBean(DruidUrlMonitorContentJson content){
        MonitorSingleSubmitScore monitorSingleSubmitScore = new MonitorSingleSubmitScore();
        monitorSingleSubmitScore.setRequestCount(content.getRequestCount());
        monitorSingleSubmitScore.setRequestTimeMillis(content.getRequestTimeMillis());
        monitorSingleSubmitScore.setRequestTimeMillisMax(content.getRequestTimeMillisMax());
        monitorSingleSubmitScore.setRequestTimeMillisMaxOccurTime(content.getRequestTimeMillisMaxOccurTime());
        monitorSingleSubmitScore.setConcurrentMax(content.getConcurrentMax());
        monitorSingleSubmitScore.setLastAccessTime(content.getLastAccessTime());
        monitorSingleSubmitScore.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorSingleSubmitScore.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        monitorSingleSubmitScore.setJdbcExecutePeak(content.getJdbcExecutePeak());
        monitorSingleSubmitScore.setHistogram(content.getHistogram().toString());
        return monitorSingleSubmitScore;
    }



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
