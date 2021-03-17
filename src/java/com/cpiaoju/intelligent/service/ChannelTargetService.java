package com.cpiaoju.intelligent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.intelligent.model.ChannelTarget;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 指标; InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
public interface ChannelTargetService extends IService<ChannelTarget> {

    List<ChannelTarget> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    ChannelTarget get(Integer id);

    List<ChannelTarget> queryRuleDetailTargetList(Integer id);

    List<ChannelTarget> queryProductRuleDetailTargetList(Integer id);
}
