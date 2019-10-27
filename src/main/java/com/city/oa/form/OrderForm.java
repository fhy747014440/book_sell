package com.city.oa.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {
    /*买家姓名*/
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "phone必填")
    private String phone;

    @NotEmpty(message = "address必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;


}
