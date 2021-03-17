package com.cpiaoju.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.dao.MessageTemplateMapper;
import com.cpiaoju.system.model.Message;
import com.cpiaoju.system.model.MessageTemplate;
import com.cpiaoju.system.service.MessageTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信模板; InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
@Service
public class MessageTemplateServiceImpl extends ServiceImpl<MessageTemplateMapper, MessageTemplate> implements MessageTemplateService {
    @Override
    public List<MessageTemplate> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
