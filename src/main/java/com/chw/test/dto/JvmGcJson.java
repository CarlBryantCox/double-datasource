package com.chw.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class JvmGcJson {

    private String name;

    private List<Measurement> measurements;
}
