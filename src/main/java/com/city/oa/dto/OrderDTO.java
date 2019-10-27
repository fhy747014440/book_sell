package com.city.oa.dto;

import com.city.oa.bean.OrderDetail;
import com.city.oa.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*订单id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;

    /*手机*/
    private String buyerPhone;

    /*地址*/
    private String buyerAddress;

    /*买家微信*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态 默认为下单*/
    private Integer orderStatus;

    /*默认为0未支付*/
    private Integer payStatus;

    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList=new ArrayList<>();
}
