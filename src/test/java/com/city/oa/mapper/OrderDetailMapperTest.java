package com.city.oa.mapper;

import com.city.oa.bean.OrderDetail;
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
public class OrderDetailMapperTest {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void findByOrderId(){
        List<OrderDetail> orderDetailList = orderDetailMapper.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList);
    }
    @Test
    public void saveTest(){
        OrderDetail result = orderDetailMapper.save(new OrderDetail(
                "11257",
                "123456",
                "1123477", "皮蛋粥"
                , new BigDecimal(12.5)
                , 1
                , "http://xxxx.com"));
        Assert.assertNotNull(result);
    }

}