package com.city.oa.mapper;


import com.city.oa.bean.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoMapperTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("789456");
        productInfo.setProductName("叫了个炸鸡");
        productInfo.setProductPrice(new BigDecimal(18.5));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("好吃的炸鸡");
        productInfo.setProductIcon("http:/eee.jpg");
        productInfo.setProductStatus(0);
        productInfo.setProductType(8);
        ProductInfo result = productInfoMapper.save(productInfo);
        Assert.assertNotNull(result);

    }
    @Test //查询上架商品
    public void findByProductStatus(){
        List<ProductInfo> byProductStatus = productInfoMapper.findByProductStatus(0);
        Assert.assertNotEquals(0,byProductStatus.size());
        System.out.println(byProductStatus);
    }

}