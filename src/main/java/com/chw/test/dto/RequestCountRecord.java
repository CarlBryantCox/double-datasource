package com.chw.test.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestCountRecord {

    private Integer seconds;

    private Long getTime;

    private Integer getCount;

    private Long avgGetTime;

    private Long getJdbcTime;

    private Integer getJdbcCount;

    private Long avgJdbcGetTime;

    private LocalDateTime creatTime;

}
