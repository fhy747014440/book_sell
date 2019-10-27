package com.city.oa.service.impl;

import com.city.oa.bean.OrderDetail;
import com.city.oa.dto.OrderDTO;
import com.city.oa.enums.OrderStatusEnum;
import com.city.oa.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    private final String BUY_OPENID="110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("李四");
        orderDTO.setBuyerAddress("撩趣");
        orderDTO.setBuyerPhone("12341564610");
        orderDTO.setBuyerOpenid(BUY_OPENID);
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("789123");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findById() {

        OrderDTO serviceById = orderService.findById("123456");
        //查询单个订单包括详细
        System.out.println(serviceById);
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> list = orderService.findList(BUY_OPENID, request);
        Assert.assertNotEquals(0,list.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findById("1572165554027789954");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findById("1572165554027789954");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }
    //支付完成测试
    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findById("1572165554027789954");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());


    }
}