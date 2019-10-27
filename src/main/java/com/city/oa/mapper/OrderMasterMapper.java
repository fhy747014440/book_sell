package com.city.oa.mapper;

import com.city.oa.bean.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterMapper extends JpaRepository<OrderMaster,String> {
    //查询某人个的订单 分页
    Page<OrderMaster> findByBuyerOpenid(String buyOpenid, Pageable pageable);

}
