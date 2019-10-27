package com.city.oa.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*
* 类别-商品*/
@Data
public class ProductVO {

    @JsonProperty("name") //序列化给前端显示name
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
