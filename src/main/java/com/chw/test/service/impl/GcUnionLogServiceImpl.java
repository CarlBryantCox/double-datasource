package com.chw.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chw.test.dto.JvmGcJson;
import com.chw.test.dto.Measurement;
import com.chw.test.entity.GcUnionLog;
import com.chw.test.mapper.GcUnionLogMapper;
import com.chw.test.service.GcUnionLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenWei
 * @since 2020-11-14
 */
@Slf4j
@Service
public class GcUnionLogServiceImpl extends ServiceImpl<GcUnionLogMapper, GcUnionLog> implements GcUnionLogService {

    private String token="Bearer7de818f4-db62-44fb-850b-3de3ba8eb6c1";

    @Resource
    private RestTemplate restTemplate;

    private static final String url = "http://jz.jtyedu.com/v1/smart/yuejuan-union-business/actuator/metrics/jvm.gc.pause";

    @Override
    public void saveGcLog() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity<JvmGcJson> exchange;
        try {
            exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JvmGcJson.class);
        } catch (HttpClientErrorException e) {
            MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
            params.add("username", "15387976997");
            params.add("password", "976997");
            params.add("scope","all");
            params.add("grant_type","password");
            params.add("platform","1");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization","Basic c21hcnQ6MGQ1NTcwNzhiYTViNGYxYzk4NzU3ZjI2MjJmY2QyYTk=");
            ResponseEntity<String> auth = restTemplate.exchange("http://jz.jtyedu.com/v1/smart/smart-school-auth/oauth/token",
                    HttpMethod.POST, new HttpEntity<>(params, httpHeaders), String.class);
            token=JSON.parseObject(auth.getBody()).getJSONObject("data").getString("access_token");
            log.info("---获取token成功---token={}",token);
            this.saveGcLog();
            return;
        }
        JvmGcJson body = exchange.getBody();
        List<Measurement> measurements = body.getMeasurements();
        if(CollectionUtils.isEmpty(measurements)){
            return;
        }
        GcUnionLog gcUnionLog = new GcUnionLog();
        for (Measurement measurement : measurements) {
            if("COUNT".equals(measurement.getStatistic())){
                gcUnionLog.setGcCount(measurement.getValue().intValue());
            }else if("TOTAL_TIME".equals(measurement.getStatistic())){
                gcUnionLog.setGcTime(measurement.getValue());
            }
        }
        GcUnionLog lastLog = this.getLastLog();
        if(lastLog!=null){
            gcUnionLog.setCountGap(gcUnionLog.getGcCount()-lastLog.getGcCount());
            gcUnionLog.setTimeGap(gcUnionLog.getGcTime()-lastLog.getGcTime());
        }
        this.save(gcUnionLog);
    }

    private GcUnionLog getLastLog(){
        QueryWrapper<GcUnionLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("Limit 1");
        return this.getOne(queryWrapper);
    }

}
