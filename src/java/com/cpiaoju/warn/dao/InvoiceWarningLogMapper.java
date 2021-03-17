package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.InvoiceWarningLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 发票预警信息; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface InvoiceWarningLogMapper extends BaseMapper<InvoiceWarningLog> {

    List<InvoiceWarningLog> list(Map<String,Object> map);

    int count(Map<String,Object> map);
}
