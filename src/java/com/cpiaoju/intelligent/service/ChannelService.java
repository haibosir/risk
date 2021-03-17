package com.cpiaoju.intelligent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.intelligent.model.Channel;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 渠道; InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
public interface ChannelService extends IService<Channel> {

    List<Channel> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
