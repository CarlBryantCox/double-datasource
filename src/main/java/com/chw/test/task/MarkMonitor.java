package com.chw.test.task;

import com.alibaba.fastjson.JSON;
import com.chw.test.dto.DruidUrlMonitorAllJson;
import com.chw.test.dto.DruidUrlMonitorResultJson;
import com.chw.test.entity.*;
import com.chw.test.service.*;
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
    private static final String url5 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-single-business/druid/webapp.json";
    private static final String url6 = "http://xn.jtyedu.com/proxy/v1/smart/yuejuan-union-business/druid/webapp.json";

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

    @Resource
    private MonitorSingleAllService monitorSingleAllService;

    @Resource
    private MonitorUnionAllService monitorUnionAllService;


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
            DruidUrlMonitorResultJson druidUrlMonitorResultJson4 = JSON.parseObject(response4.getBody(), DruidUrlMonitorResultJson.class);
            if(druidUrlMonitorResultJson4!=null && druidUrlMonitorResultJson4.getContent()!=null){
                monitorUnionSubmitScoreService.save(MonitorUnionSubmitScore.getBean(druidUrlMonitorResultJson4.getContent()));
            }
            ResponseEntity<String> response5 = restTemplate.exchange(url5, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorAllJson druidUrlMonitorResultJson5 = JSON.parseObject(response5.getBody(), DruidUrlMonitorAllJson.class);
            if(druidUrlMonitorResultJson5!=null && druidUrlMonitorResultJson5.getContent().get(0)!=null){
                monitorSingleAllService.save(MonitorSingleAll.getBean(druidUrlMonitorResultJson5.getContent().get(0)));
            }
            ResponseEntity<String> response6 = restTemplate.exchange(url6, HttpMethod.POST, requestEntity, String.class);
            DruidUrlMonitorAllJson druidUrlMonitorResultJson6 = JSON.parseObject(response6.getBody(), DruidUrlMonitorAllJson.class);
            if(druidUrlMonitorResultJson6!=null && druidUrlMonitorResultJson6.getContent().get(0)!=null){
                monitorUnionAllService.save(MonitorUnionAll.getBean(druidUrlMonitorResultJson6.getContent().get(0)));
            }
        } catch (RestClientException e) {
            log.info(e.toString());
        }
        log.info("----获取监控记录完成----"+ LocalDateTime.now());
    }

}
