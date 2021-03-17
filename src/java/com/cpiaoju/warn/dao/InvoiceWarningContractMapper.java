package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.InvoiceWarningContract;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface InvoiceWarningContractMapper extends BaseMapper<InvoiceWarningContract> {

    List<InvoiceWarningContract> list(Map<String,Object> map);
}
