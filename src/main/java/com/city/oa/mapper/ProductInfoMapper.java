package com.city.oa.mapper;

import com.city.oa.bean.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//对象主键
public interface ProductInfoMapper extends JpaRepository<ProductInfo,String> {

    //查询上架的商品
    List<ProductInfo> findByProductStatus(Integer productStatus);



}
