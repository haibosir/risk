package com.cpiaoju.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 短信记录; InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-11-26
 */
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
