package com.cpiaoju.warn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.warn.model.FeedbackAnnex;

import java.util.List;

/**
 * <p>
 * 反馈文件; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2021-01-04
 */
public interface FeedbackAnnexMapper extends BaseMapper<FeedbackAnnex> {

    List<FeedbackAnnex> list(Integer feedId);

}
