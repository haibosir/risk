package com.cpiaoju.intelligent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.intelligent.dao.PlatformRuleApprovalMapper;
import com.cpiaoju.intelligent.model.PlatformRuleApproval;
import com.cpiaoju.intelligent.service.PlatformRuleApprovalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 规则审核日志; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class PlatformRuleApprovalServiceImpl extends ServiceImpl<PlatformRuleApprovalMapper, PlatformRuleApproval> implements PlatformRuleApprovalService {
    @Override
    public List<PlatformRuleApproval> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
