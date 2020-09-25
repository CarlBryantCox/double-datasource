package com.chw.test.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DruidUrlMonitorContentJson {

    private List<Integer> Histogram;

    private Integer ConcurrentMax;

    private Integer RequestCount;

    private Long RequestTimeMillis;

    private LocalDateTime LastAccessTime;

    private Integer JdbcExecuteCount;

    private Integer JdbcExecutePeak;

    private Long JdbcExecuteTimeMillis;

    private Integer RequestTimeMillisMax;

    private LocalDateTime RequestTimeMillisMaxOccurTime;
}
