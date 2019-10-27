package com.city.oa.mapper;


import com.city.oa.bean.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void findOne() {
        Optional<ProductCategory> one = mapper.findById(1);
        System.out.println(one);
    }
    @Test
    @Transactional
    public void saveTest(){
        /*ProductCategory category = new
                ProductCategory("风味篇", 4);*/
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("小朋友最喜欢");
        productCategory.setCategoryType(6);
        mapper.save(productCategory);
       /* Optional<ProductCategory> category = mapper.findById(1);
        category.get().setCategoryType(10);*/
       Assert.assertNotNull(productCategory);
        //Assert.assertNotEquals(null,productCategory);
    }
    @Test
    public void findAllByCategoryTypeIn(){
        List<Integer> list= Arrays.asList(2,3,6);
        List<ProductCategory> result = mapper.findAllByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result);
    }

}