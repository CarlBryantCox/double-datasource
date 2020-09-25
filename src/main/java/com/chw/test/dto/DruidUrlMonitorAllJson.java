package com.chw.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class DruidUrlMonitorAllJson {

    private Integer ResultCode;

    private List<DruidUrlMonitorContentJson> Content;
}
