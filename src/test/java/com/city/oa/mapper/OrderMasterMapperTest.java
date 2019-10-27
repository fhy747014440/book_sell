package com.city.oa.mapper;

import com.city.oa.bean.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterMapperTest {
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    private final String OPENID="11011";

    @Test
    public void findByBuyerOpenid(){
        PageRequest request=PageRequest.of(0,3);
        Page<OrderMaster> result = orderMasterMapper.findByBuyerOpenid(OPENID, request);
        System.out.println(result.getTotalElements());

    }
    @Test //测试下订单
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12345678910");
        orderMaster.setBuyerAddress("慕课");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(10.5));
        OrderMaster save = orderMasterMapper.save(orderMaster);
        Assert.assertNotNull(save);
    }


}