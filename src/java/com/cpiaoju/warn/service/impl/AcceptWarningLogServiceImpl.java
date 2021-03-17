package com.cpiaoju.warn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.warn.dao.AcceptWarningLogMapper;
import com.cpiaoju.warn.model.AcceptWarningLog;
import com.cpiaoju.warn.service.AcceptWarningLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 风险预警-承兑提示; InnoDB free: 8192 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
@Service
public class AcceptWarningLogServiceImpl extends ServiceImpl<AcceptWarningLogMapper, AcceptWarningLog> implements AcceptWarningLogService {

    @Override
    public List<AcceptWarningLog> list(Map<String, Object> map) {
        return this.baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return this.baseMapper.count(map);
    }
}
