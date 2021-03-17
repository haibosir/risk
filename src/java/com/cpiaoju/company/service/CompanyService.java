package com.cpiaoju.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.company.model.Company;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业信息; InnoDB free: 7168 kB 服务类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface CompanyService extends IService<Company> {

    List<Company> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    Company get(Integer id);

}
