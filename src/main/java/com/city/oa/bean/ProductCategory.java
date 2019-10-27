package com.city.oa.bean;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@ToString
public class ProductCategory {
  /*类目id*/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;
  /*类目名称*/
  private String categoryName;
  /*类目编号*/
  private Integer categoryType;
  private Date createTime;
  private Date updateTime;

  public ProductCategory(String categoryName, Integer categoryType) {
    this.categoryName = categoryName;
    this.categoryType = categoryType;
  }

  public ProductCategory() {

  }
}
