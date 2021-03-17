package com.cpiaoju.intelligent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.model.ChannelTarget;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 指标; InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-11-27
 */
public interface ChannelTargetMapper extends BaseMapper<ChannelTarget> {

    List<ChannelTarget> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    ChannelTarget get(Integer id);

    List<ChannelTarget> queryRuleDetailTargetList(Integer id);

    List<ChannelTarget> queryProductRuleDetailTargetList(Integer id);



}
