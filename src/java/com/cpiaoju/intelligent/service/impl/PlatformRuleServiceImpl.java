package com.cpiaoju.intelligent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.dao.PlatformRuleMapper;
import com.cpiaoju.intelligent.model.PlatformRule;
import com.cpiaoju.intelligent.service.PlatformRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class PlatformRuleServiceImpl extends ServiceImpl<PlatformRuleMapper, PlatformRule> implements PlatformRuleService {

    @Override
    public List<PlatformRule> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
