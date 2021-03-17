package com.cpiaoju.intelligent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.dao.ChannelTargetMapper;
import com.cpiaoju.intelligent.model.ChannelTarget;
import com.cpiaoju.intelligent.service.ChannelTargetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 指标; InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@Service
public class ChannelTargetServiceImpl extends ServiceImpl<ChannelTargetMapper, ChannelTarget> implements ChannelTargetService {


    @Override
    public ChannelTarget get(Integer id) {
        return baseMapper.get(id);
    }

    @Override
    public List<ChannelTarget> queryRuleDetailTargetList(Integer id) {
        return baseMapper.queryRuleDetailTargetList(id);
    }

    @Override
    public List<ChannelTarget> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }

    @Override
    public List<ChannelTarget> queryProductRuleDetailTargetList(Integer id) {
        return baseMapper.queryProductRuleDetailTargetList(id);
    }
}
