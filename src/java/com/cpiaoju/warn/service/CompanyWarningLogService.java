package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.CompanyWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警记录(企业风险,发票风险,承兑风险); InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyWarningLogService extends IService<CompanyWarningLog> {

    List<CompanyWarningLog> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
