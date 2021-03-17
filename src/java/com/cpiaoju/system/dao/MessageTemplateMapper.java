package com.cpiaoju.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.model.Message;
import com.cpiaoju.system.model.MessageTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 短信模板; InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
public interface MessageTemplateMapper extends BaseMapper<MessageTemplate> {

    List<MessageTemplate> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
