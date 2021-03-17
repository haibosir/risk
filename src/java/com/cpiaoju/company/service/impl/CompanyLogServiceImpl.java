package com.cpiaoju.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cpiaoju.company.dao.CompanyLogMapper;
import com.cpiaoju.company.model.CompanyLog;
import com.cpiaoju.company.service.CompanyLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业信息-日志表; InnoDB free: 7168 kB; (`company_id`) REFER `risk_manager/sys_company`( 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class CompanyLogServiceImpl extends ServiceImpl<CompanyLogMapper, CompanyLog> implements CompanyLogService {

}
