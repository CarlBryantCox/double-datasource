package com.chw.test.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DruidUrlMonitorContentJson {

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
