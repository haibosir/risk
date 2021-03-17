package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.FeedbackAnnexMapper;
import com.cpiaoju.warn.model.FeedbackAnnex;
import com.cpiaoju.warn.service.FeedbackAnnexService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 反馈文件; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
@Service
public class FeedbackAnnexServiceImpl extends ServiceImpl<FeedbackAnnexMapper, FeedbackAnnex> implements FeedbackAnnexService {

    @Override
    public List<FeedbackAnnex> list(Integer feedId) {
        return this.baseMapper.list(feedId);
    }
}
