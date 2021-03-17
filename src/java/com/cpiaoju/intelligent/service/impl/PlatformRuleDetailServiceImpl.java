package com.cpiaoju.intelligent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.intelligent.dao.PlatformRuleDetailMapper;
import com.cpiaoju.intelligent.model.PlatformRuleDetail;
import com.cpiaoju.intelligent.service.PlatformRuleDetailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 平台规则-详情; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class PlatformRuleDetailServiceImpl extends ServiceImpl<PlatformRuleDetailMapper, PlatformRuleDetail> implements PlatformRuleDetailService {

    @Override
    public List<PlatformRuleDetail> listFull(@Param("ids") List<Long> ids) {
        return baseMapper.listFull(ids);
    }

    @Override
    public int batchRemove(Long id) {
        return baseMapper.batchRemove(id);
    }
}
