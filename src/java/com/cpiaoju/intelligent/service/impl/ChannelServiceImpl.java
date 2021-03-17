package com.cpiaoju.intelligent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.intelligent.dao.ChannelMapper;
import com.cpiaoju.intelligent.model.Channel;
import com.cpiaoju.intelligent.service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 渠道; InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements ChannelService {

    @Override
    public List<Channel> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
