package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.FeedbackMapper;
import com.cpiaoju.warn.model.Feedback;
import com.cpiaoju.warn.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 反馈记录; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public List<Feedback> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }
}
