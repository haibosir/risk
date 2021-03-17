package com.cpiaoju.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.model.Message;
import com.cpiaoju.system.model.MessageTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信模板; InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
public interface MessageTemplateService extends IService<MessageTemplate> {

    List<MessageTemplate> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
