package com.cpiaoju.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.common.PageResult;
import com.cpiaoju.system.model.LoginRecord;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface LoginRecordService extends IService<LoginRecord> {

    PageResult<LoginRecord> listFull(PageParam page);

}
