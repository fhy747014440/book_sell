package com.city.oa.service;

import com.city.oa.dto.OrderDTO;

/**
 * 买家逻辑
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);


    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
