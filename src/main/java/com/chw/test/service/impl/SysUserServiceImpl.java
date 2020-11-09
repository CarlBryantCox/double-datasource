package com.chw.test.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chw.test.dao.SysUserMapper;
import com.chw.test.entity.*;
import com.chw.test.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.*;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@SuppressWarnings({"Duplicates"})
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private MonitorSingleGetPaperService monitorSingleGetPaperService;

    @Resource
    private MonitorSingleSubmitScoreService monitorSingleSubmitScoreService;

    @Resource
    private MonitorUnionGetPaperService monitorUnionGetPaperService;

    @Resource
    private MonitorUnionSubmitScoreService monitorUnionSubmitScoreService;

    @Resource
    private RecordUnionGetPaperService recordUnionGetPaperService;

    @Resource
    private RecordSingleGetPaperService recordSingleGetPaperService;

    @Resource
    private RecordUnionSubmitScoreService recordUnionSubmitScoreService;

    @Resource
    private RecordSingleSubmitScoreService recordSingleSubmitScoreService;

    @Resource
    private RecordSingleAllService recordSingleAllService;

    @Resource
    private RecordUnionAllService recordUnionAllService;

    @Resource
    private MonitorSingleAllService monitorSingleAllService;

    @Resource
    private MonitorUnionAllService monitorUnionAllService;

    @Override
    public List<SysUser> getAllUser() {
        return sysUserMapper.getAllUser();
    }

    @Transactional(rollbackFor = Exception.class,transactionManager = "secondTransactionManager")
    @Override
    public String saveUser(Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("test"+id);
        sysUser.setNickName("test"+id);
        //sysUser.setPhone("19900000000");
        sysUser.setPassword("123456");
        this.save(sysUser);
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println(3/(i-1));
        return "user";
    }

    @Override
    public Map<String, Object> getRecord(Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("singleGetPaper",this.singleGetPaper(size));
        map.put("singleSubmitScore",this.singleSubmitScore(size));
        map.put("singleAll",this.singleAll(size));
        map.put("unionGetPaper",this.unionGetPaper(size));
        map.put("unionSubmitScore",this.unionSubmitScore(size));
        map.put("unionAll",this.unionAll(size));
        return map;
    }

    @Override
    public List<RecordSingleGetPaper> singleGetPaper(Integer size) {
        List<RecordSingleGetPaper> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorSingleGetPaper> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorSingleGetPaper> list = monitorSingleGetPaperService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorSingleGetPaper newRecord = list.get(i-1);
                MonitorSingleGetPaper oldRecord = list.get(i);
                RecordSingleGetPaper recordSingleGetPaper = new RecordSingleGetPaper();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordSingleGetPaper.setSeconds((int) (between.toMillis()/1000));
                recordSingleGetPaper.setCreatTime(newRecord.getCreateTime());
                recordSingleGetPaper.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordSingleGetPaper.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordSingleGetPaper.setAvgGetTime(recordSingleGetPaper.getGetCount()==0?0:recordSingleGetPaper.getGetTime()/recordSingleGetPaper.getGetCount());
                recordSingleGetPaper.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordSingleGetPaper.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordSingleGetPaper.setAvgJdbcGetTime(recordSingleGetPaper.getGetJdbcCount()==0?0:recordSingleGetPaper.getGetJdbcTime()/recordSingleGetPaper.getGetJdbcCount());
                countRecordList.add(recordSingleGetPaper);
            }
            recordSingleGetPaperService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @Override
    public List<RecordSingleSubmitScore> singleSubmitScore(Integer size) {
        List<RecordSingleSubmitScore> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorSingleSubmitScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorSingleSubmitScore> list = monitorSingleSubmitScoreService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorSingleSubmitScore newRecord = list.get(i-1);
                MonitorSingleSubmitScore oldRecord = list.get(i);
                RecordSingleSubmitScore recordSingleSubmitScore = new RecordSingleSubmitScore();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordSingleSubmitScore.setSeconds((int) (between.toMillis()/1000));
                recordSingleSubmitScore.setCreatTime(newRecord.getCreateTime());
                recordSingleSubmitScore.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordSingleSubmitScore.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordSingleSubmitScore.setAvgGetTime(recordSingleSubmitScore.getGetCount()==0?0:recordSingleSubmitScore.getGetTime()/recordSingleSubmitScore.getGetCount());
                recordSingleSubmitScore.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordSingleSubmitScore.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordSingleSubmitScore.setAvgJdbcGetTime(recordSingleSubmitScore.getGetJdbcCount()==0?0:recordSingleSubmitScore.getGetJdbcTime()/recordSingleSubmitScore.getGetJdbcCount());
                countRecordList.add(recordSingleSubmitScore);
            }
            recordSingleSubmitScoreService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @Override
    public List<RecordSingleAll> singleAll(Integer size) {
        List<RecordSingleAll> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorSingleAll> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorSingleAll> list = monitorSingleAllService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorSingleAll newRecord = list.get(i-1);
                MonitorSingleAll oldRecord = list.get(i);
                RecordSingleAll recordSingleAll = new RecordSingleAll();
                Duration between = Duration.between(oldRecord.getCreateTime(), newRecord.getCreateTime());
                recordSingleAll.setSeconds((int) (between.toMillis()/1000));
                recordSingleAll.setCreatTime(newRecord.getCreateTime());
                recordSingleAll.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordSingleAll.setQps((recordSingleAll.getGetCount())/(int) (between.toMillis()/1000));
                recordSingleAll.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordSingleAll.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordSingleAll.setAvgJdbcGetTime(recordSingleAll.getGetJdbcCount()==0?0:recordSingleAll.getGetJdbcTime()/recordSingleAll.getGetJdbcCount());
                countRecordList.add(recordSingleAll);
            }
            recordSingleAllService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @Override
    public List<RecordUnionGetPaper> unionGetPaper(Integer size) {
        List<RecordUnionGetPaper> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorUnionGetPaper> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorUnionGetPaper> list = monitorUnionGetPaperService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorUnionGetPaper newRecord = list.get(i-1);
                MonitorUnionGetPaper oldRecord = list.get(i);
                RecordUnionGetPaper recordUnionGetPaper = new RecordUnionGetPaper();
                Duration between = Duration.between(oldRecord.getCreateTime(),newRecord.getCreateTime());
                recordUnionGetPaper.setSeconds((int) (between.toMillis()/1000));
                recordUnionGetPaper.setCreatTime(newRecord.getCreateTime());
                recordUnionGetPaper.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordUnionGetPaper.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordUnionGetPaper.setAvgGetTime(recordUnionGetPaper.getGetCount()==0?0:recordUnionGetPaper.getGetTime()/recordUnionGetPaper.getGetCount());
                recordUnionGetPaper.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordUnionGetPaper.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordUnionGetPaper.setAvgJdbcGetTime(recordUnionGetPaper.getGetJdbcCount()==0?0:recordUnionGetPaper.getGetJdbcTime()/recordUnionGetPaper.getGetJdbcCount());
                countRecordList.add(recordUnionGetPaper);
            }
            recordUnionGetPaperService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @Override
    public List<RecordUnionSubmitScore> unionSubmitScore(Integer size) {
        List<RecordUnionSubmitScore> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorUnionSubmitScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorUnionSubmitScore> list = monitorUnionSubmitScoreService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorUnionSubmitScore newRecord = list.get(i-1);
                MonitorUnionSubmitScore oldRecord = list.get(i);
                RecordUnionSubmitScore recordUnionSubmitScore = new RecordUnionSubmitScore();
                Duration between = Duration.between(oldRecord.getCreateTime(), newRecord.getCreateTime());
                recordUnionSubmitScore.setSeconds((int) (between.toMillis()/1000));
                recordUnionSubmitScore.setCreatTime(newRecord.getCreateTime());
                recordUnionSubmitScore.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordUnionSubmitScore.setGetTime(newRecord.getRequestTimeMillis()-oldRecord.getRequestTimeMillis());
                recordUnionSubmitScore.setAvgGetTime(recordUnionSubmitScore.getGetCount()==0?0:recordUnionSubmitScore.getGetTime()/recordUnionSubmitScore.getGetCount());
                recordUnionSubmitScore.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordUnionSubmitScore.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordUnionSubmitScore.setAvgJdbcGetTime(recordUnionSubmitScore.getGetJdbcCount()==0?0:recordUnionSubmitScore.getGetJdbcTime()/recordUnionSubmitScore.getGetJdbcCount());
                countRecordList.add(recordUnionSubmitScore);
            }
            recordUnionSubmitScoreService.saveBatch(countRecordList);
        }
        return countRecordList;
    }

    @Override
    public List<RecordUnionAll> unionAll(Integer size) {
        List<RecordUnionAll> countRecordList = new ArrayList<>();
        QueryWrapper<MonitorUnionAll> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("LIMIT "+size);
        List<MonitorUnionAll> list = monitorUnionAllService.list(queryWrapper);
        if(list.size()>1){
            for (int i = list.size()-1; i > 0; i--) {
                MonitorUnionAll newRecord = list.get(i-1);
                MonitorUnionAll oldRecord = list.get(i);
                RecordUnionAll recordUnionAll = new RecordUnionAll();
                Duration between = Duration.between(oldRecord.getCreateTime(), newRecord.getCreateTime());
                recordUnionAll.setSeconds((int) (between.toMillis()/1000));
                recordUnionAll.setCreatTime(newRecord.getCreateTime());
                recordUnionAll.setGetCount(newRecord.getRequestCount()-oldRecord.getRequestCount());
                recordUnionAll.setQps((recordUnionAll.getGetCount())/recordUnionAll.getSeconds());
                recordUnionAll.setGetJdbcCount(newRecord.getJdbcExecuteCount()-oldRecord.getJdbcExecuteCount());
                recordUnionAll.setGetJdbcTime(newRecord.getJdbcExecuteTimeMillis()-oldRecord.getJdbcExecuteTimeMillis());
                recordUnionAll.setAvgJdbcGetTime(recordUnionAll.getGetJdbcCount()==0?0:recordUnionAll.getGetJdbcTime()/recordUnionAll.getGetJdbcCount());
                countRecordList.add(recordUnionAll);
            }
            recordUnionAllService.saveBatch(countRecordList);
        }
        return countRecordList;
    }
}
