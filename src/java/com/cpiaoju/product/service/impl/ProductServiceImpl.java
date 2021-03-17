package com.cpiaoju.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpiaoju.common.PageParam;
import com.cpiaoju.product.dao.ProductMapper;
import com.cpiaoju.product.model.Product;
import com.cpiaoju.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品; InnoDB free: 7168 kB 服务实现类
 * </p>
 *
 * @author huhb
 * @since 2020-12-09
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public List<Product> listFull(PageParam page) {
        return baseMapper.listFull(page);
    }

    @Override
    public List<Product> list(Map<String, Object> map) {
        return baseMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return baseMapper.count(map);
    }
}
