package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.CompanyWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警记录(企业风险,发票风险,承兑风险); InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyWarningLogMapper extends BaseMapper<CompanyWarningLog> {

    List<CompanyWarningLog> list(Map<String, Object> map);

    int count(Map<String, Object> map);

}
