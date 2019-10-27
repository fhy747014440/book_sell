package com.city.oa.bean;

import com.city.oa.enums.OrderStatusEnum;
import com.city.oa.enums.PayStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
public class OrderMaster {

  /*订单id*/
  @Id
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
  private Integer orderStatus =OrderStatusEnum.NEW.getCode();

  /*默认为0未支付*/
  private Integer payStatus=PayStatusEnum.WAIT.getCode();

  /*创建时间*/
  private Date createTime;

  /*更新时间*/
  private Date updateTime;


  public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount) {
    this.orderId = orderId;
    this.buyerName = buyerName;
    this.buyerPhone = buyerPhone;
    this.buyerAddress = buyerAddress;
    this.buyerOpenid = buyerOpenid;
    this.orderAmount = orderAmount;
  }
}


