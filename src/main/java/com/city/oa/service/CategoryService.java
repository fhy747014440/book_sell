package com.city.oa.service;

import com.city.oa.bean.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<ProductCategory> findById(Integer categoryId);

   List<ProductCategory> findAll();

   List<ProductCategory> findAllByCategoryTypeIn(List<Integer> categoryTypeList);

   ProductCategory save(ProductCategory productCategory);

}
