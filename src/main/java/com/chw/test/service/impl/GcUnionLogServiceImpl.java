package com.chw.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chw.test.dto.JvmGcJson;
import com.chw.test.dto.Measurement;
import com.chw.test.entity.GcUnionLog;
import com.chw.test.mapper.GcUnionLogMapper;
import com.chw.test.service.GcUnionLogService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
@Service
public class GcUnionLogServiceImpl extends ServiceImpl<GcUnionLogMapper, GcUnionLog> implements GcUnionLogService {

    @Resource
    private RestTemplate restTemplate;

    private static final String url = "http://jz.jtyedu.com/v1/smart/yuejuan-union-business/actuator/metrics/jvm.gc.pause";

    @Override
    public void saveGcLog() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer7de818f4-db62-44fb-850b-3de3ba8eb6c1");
        HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity<JvmGcJson> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JvmGcJson.class);
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
