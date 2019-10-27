package com.city.oa.service.impl;

import com.city.oa.bean.ProductInfo;
import com.city.oa.mapper.ProductInfoMapper;
import com.city.oa.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //注入dao
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public Optional<ProductInfo> findById(String productId) {
        return productInfoMapper.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findByProductStatus(0);

    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoMapper.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoMapper.save(productInfo);
    }
}
