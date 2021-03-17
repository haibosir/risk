package com.cpiaoju.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.system.model.LoginRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2019-02-11
 */
public interface LoginRecordMapper extends BaseMapper<LoginRecord> {

    List<LoginRecord> listFull(@Param("page")PageParam page);

}
