package com.cpiaoju.intelligent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.intelligent.model.Channel;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 渠道; InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
public interface ChannelMapper extends BaseMapper<Channel> {

    List<Channel> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
