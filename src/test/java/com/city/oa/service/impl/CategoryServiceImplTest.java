package com.city.oa.service.impl;

import com.city.oa.bean.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById() {
        Optional<ProductCategory> byId = categoryService.findById(2);
        Assert.assertEquals(new Integer(2),byId.get().getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());

    }

    @Test
    public void findAllByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = categoryService.findAllByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0,categoryTypeIn.size());

    }

    @Test
    public void save() {
        ProductCategory save = categoryService.save(new ProductCategory("女生专享", 11));
        Assert.assertNotEquals(0,save);
    }
}