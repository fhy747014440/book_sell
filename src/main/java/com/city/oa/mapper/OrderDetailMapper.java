package com.city.oa.mapper;

import com.city.oa.bean.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//订单详情
public interface OrderDetailMapper extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
