package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.InvoiceWarningContract;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 无票保理-贸易合同表; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface InvoiceWarningContractService extends IService<InvoiceWarningContract> {

    List<InvoiceWarningContract> list(Map<String,Object> map);
}
