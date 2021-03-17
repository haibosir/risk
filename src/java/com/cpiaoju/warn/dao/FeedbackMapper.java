package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.Feedback;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 反馈记录; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface FeedbackMapper extends BaseMapper<Feedback> {

    List<Feedback> list(Map<String,Object> map);
}
