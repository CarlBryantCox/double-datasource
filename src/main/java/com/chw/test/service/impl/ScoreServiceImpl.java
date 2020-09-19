package com.chw.test.service.impl;

import com.chw.test.entity.Score;
import com.chw.test.mapper.ScoreMapper;
import com.chw.test.service.ScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-19
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

}
