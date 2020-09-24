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
public class MonitorUnionSubmitScore extends Model<MonitorUnionSubmitScore> {

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

    public static MonitorUnionSubmitScore getBean(DruidUrlMonitorContentJson content){
        MonitorUnionSubmitScore monitorUnionSubmitScore = new MonitorUnionSubmitScore();
        monitorUnionSubmitScore.setRequestCount(content.getRequestCount());
        monitorUnionSubmitScore.setRequestTimeMillis(content.getRequestTimeMillis());
        monitorUnionSubmitScore.setRequestTimeMillisMax(content.getRequestTimeMillisMax());
        monitorUnionSubmitScore.setRequestTimeMillisMaxOccurTime(content.getRequestTimeMillisMaxOccurTime());
        monitorUnionSubmitScore.setConcurrentMax(content.getConcurrentMax());
        monitorUnionSubmitScore.setLastAccessTime(content.getLastAccessTime());
        monitorUnionSubmitScore.setJdbcExecuteCount(content.getJdbcExecuteCount());
        monitorUnionSubmitScore.setJdbcExecuteTimeMillis(content.getJdbcExecuteTimeMillis());
        monitorUnionSubmitScore.setJdbcExecutePeak(content.getJdbcExecutePeak());
        return monitorUnionSubmitScore;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
