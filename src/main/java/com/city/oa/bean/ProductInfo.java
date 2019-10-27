package com.city.oa.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ProductInfo {

  @Id
  private String productId;

  /*名字*/
  private String productName;

  /*单价*/
  private BigDecimal productPrice;

  /*库存*/
  private Integer productStock;

  /*描述*/
  private String productDescription;

  /*小图*/
  private String productIcon;

  /*状态 0正常1下架*/
  private Integer productStatus;

  /*类目编号*/
  private Integer productType;

  /*时间*/
  private Date createTime;

  private Date updateTime;



}
