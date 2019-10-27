package com.city.oa.VO;

import lombok.Data;

/**
 * http:请求返回最外层对象
 * 返回给前端
 */
@Data
public class ResultVO<T> {
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    //定义data 泛型对象
    /*具体内容*/
    private T data;

}
