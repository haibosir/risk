package com.cpiaoju.intelligent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.model.PlatformRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface PlatformRuleMapper extends BaseMapper<PlatformRule> {

    List<PlatformRule> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
