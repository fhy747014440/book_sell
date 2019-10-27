package com.city.oa.service;

import com.city.oa.bean.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {

    Optional<ProductInfo> findById(String productId);

    //查询所有上架商品列表
    List<ProductInfo> findUpAll();

    //查询商品所有列表分页
    Page<ProductInfo> findAll(Pageable pageable);

    //添加新商品
    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存


}
