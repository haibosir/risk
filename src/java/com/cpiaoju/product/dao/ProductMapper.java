package com.cpiaoju.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.product.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品; InnoDB free: 7168 kB Mapper 接口
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
public interface ProductMapper extends BaseMapper<Product> {


    List<Product> listFull(@Param("page") PageParam page);

    List<Product> list(Map<String,Object> map);

    int count(Map<String,Object> map);
}
