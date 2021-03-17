package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.AcceptWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 风险预警-承兑提示; InnoDB free: 8192 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-05
 */
public interface AcceptWarningLogMapper extends BaseMapper<AcceptWarningLog> {

    List<AcceptWarningLog> list(Map<String,Object> map);

    int count(Map<String,Object> map);

}
