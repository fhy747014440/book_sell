package com.city.oa.service.impl;

import com.city.oa.bean.ProductInfo;
import com.city.oa.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findById() {
        Optional<ProductInfo> result = productInfoService.findById("789456");

        Assert.assertEquals("789456",result.get().getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productInfoService.findUpAll();
        Assert.assertNotEquals(0,upAll);
    }

    @Test
    public void findAll() {
        PageRequest request=PageRequest.of(0,2);
        Page<ProductInfo> infoPage = productInfoService.findAll(request);
        System.out.println(infoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("789123");
        productInfo.setProductName("叫了个牛蛙");
        productInfo.setProductPrice(new BigDecimal(18.5));
        productInfo.setProductStock(20);
        productInfo.setProductDescription("好吃的牛蛙");
        productInfo.setProductIcon("http:/eee.jpg");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setProductType(7);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}