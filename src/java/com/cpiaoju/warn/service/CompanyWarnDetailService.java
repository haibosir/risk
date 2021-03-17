package com.cpiaoju.warn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.warn.model.CompanyWarnDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预警信息; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyWarnDetailService extends IService<CompanyWarnDetail> {

    List<CompanyWarnDetail> list(Map<String, Object> map);

}
