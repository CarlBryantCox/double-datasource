package com.chw.test.task;

import com.alibaba.fastjson.JSON;
import com.chw.test.dto.DruidUrlMonitorResultJson;
import com.chw.test.entity.MonitorSingleGetPaper;
import com.chw.test.entity.MonitorSingleSubmitScore;
import com.chw.test.entity.MonitorUnionGetPaper;
import com.chw.test.entity.MonitorUnionSubmitScore;
import com.chw.test.service.MonitorSingleGetPaperService;
import com.chw.test.service.MonitorSingleSubmitScoreService;
import com.chw.test.service.MonitorUnionGetPaperService;
import com.chw.test.service.MonitorUnionSubmitScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SuppressWarnings({"Duplicates"})
@Slf4j
@Component
public class MarkMonitor {

    private static final String url1 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-single-business/druid/weburi-/api/markingTask/getPaper.json";
    private static final String url2 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-single-business/druid/weburi-/api/markingTask/submitScore.json";
    private static final String url3 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-union-business/druid/weburi-/api/markingTask/getPaper.json";
    private static final String url4 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-union-business/druid/weburi-/api/markingTask/submitScore.json";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MonitorSingleGetPaperService monitorSingleGetPaperService;

    @Resource
    private MonitorSingleSubmitScoreService monitorSingleSubmitScoreService;

    @Resource
    private MonitorUnionGetPaperService monitorUnionGetPaperService;

    @Resource
    private MonitorUnionSubmitScoreService monitorUnionSubmitScoreService;


    //单位毫秒
    @Scheduled(fixedDelay = 30000)
    public void monitorSingleGetPaper(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("loginUsername", "druid");
        params.add("loginPassword", "123456");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        try {
            ResponseEntity<String> response1 = restTemplate.exchange(url1, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorResultJson druidUrlMonitorResultJson1 = JSON.parseObject(response1.getBody(), DruidUrlMonitorResultJson.class);
            if(druidUrlMonitorResultJson1!=null && druidUrlMonitorResultJson1.getContent()!=null){
                monitorSingleGetPaperService.save(MonitorSingleGetPaper.getBean(druidUrlMonitorResultJson1.getContent()));
            }
            ResponseEntity<String> response2 = restTemplate.exchange(url2, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorResultJson druidUrlMonitorResultJson2 = JSON.parseObject(response2.getBody(), DruidUrlMonitorResultJson.class);
            if(druidUrlMonitorResultJson2!=null && druidUrlMonitorResultJson2.getContent()!=null){
                monitorSingleSubmitScoreService.save(MonitorSingleSubmitScore.getBean(druidUrlMonitorResultJson2.getContent()));
            }
            ResponseEntity<String> response3 = restTemplate.exchange(url3, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorResultJson druidUrlMonitorResultJson3 = JSON.parseObject(response3.getBody(), DruidUrlMonitorResultJson.class);
            if(druidUrlMonitorResultJson3!=null && druidUrlMonitorResultJson3.getContent()!=null){
                monitorUnionGetPaperService.save(MonitorUnionGetPaper.getBean(druidUrlMonitorResultJson3.getContent()));
            }
            ResponseEntity<String> response4 = restTemplate.exchange(url4, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorResultJson druidUrlMonitorResultJson = JSON.parseObject(response4.getBody(), DruidUrlMonitorResultJson.class);
            if(druidUrlMonitorResultJson!=null && druidUrlMonitorResultJson.getContent()!=null){
                monitorUnionSubmitScoreService.save(MonitorUnionSubmitScore.getBean(druidUrlMonitorResultJson.getContent()));
            }
        } catch (RestClientException e) {
            log.info(e.toString());
        }
        log.info("----获取监控记录完成----"+ LocalDateTime.now());
    }

}
