package com.city.oa.service.impl;

import com.city.oa.bean.ProductCategory;
import com.city.oa.mapper.ProductCategoryMapper;
import com.city.oa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper repository;

    @Override
    public Optional<ProductCategory>  findById(Integer categoryId) {
        return repository.findById(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findAllByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findAllByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
