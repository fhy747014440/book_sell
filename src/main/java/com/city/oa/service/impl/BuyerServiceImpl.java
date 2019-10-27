package com.city.oa.service.impl;

import com.city.oa.dto.OrderDTO;
import com.city.oa.enums.ResultEnum;
import com.city.oa.exception.SellException;
import com.city.oa.service.BuyerService;
import com.city.oa.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findById(orderId);
        if (orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致 openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

    //查询订单前判断是否属于自己的订单
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid,orderId);
    }
    //取消订单前判断是否属于自己的订单
    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO= checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            log.error("【取消订单】该订单不存在无法取消 orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
}
