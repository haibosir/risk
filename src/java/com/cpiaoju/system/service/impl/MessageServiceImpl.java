package com.cpiaoju.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.dao.MessageMapper;
import com.cpiaoju.system.model.Message;
import com.cpiaoju.system.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信记录; InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public List<Message> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
