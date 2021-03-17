package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.InvoiceWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 发票预警信息; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface InvoiceWarningLogService extends IService<InvoiceWarningLog> {

    List<InvoiceWarningLog> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
