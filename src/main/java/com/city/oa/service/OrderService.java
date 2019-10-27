package com.city.oa.service;

import com.city.oa.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderService {
    //创建订单 1个订单可以又多个商品
    OrderDTO create(OrderDTO orderDTO);
    //查询订单 单个或
    OrderDTO findById(String orderId);
    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

}
