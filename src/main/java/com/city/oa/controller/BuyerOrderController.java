package com.city.oa.controller;

import com.city.oa.VO.ResultVO;
import com.city.oa.converter.OrderForm2orderDTO;
import com.city.oa.dto.OrderDTO;
import com.city.oa.enums.ResultEnum;
import com.city.oa.exception.SellException;
import com.city.oa.form.OrderForm;
import com.city.oa.service.BuyerService;
import com.city.oa.service.OrderService;
import com.city.oa.utils.ResultVOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm
            ,BindingResult bindingResult)  {

       if (bindingResult.hasErrors()){
           log.error("【创建订单】参数不正确 orderForm={}",orderForm);
           throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                  bindingResult.getFieldError().getDefaultMessage());
       }
        OrderDTO orderDTO= OrderForm2orderDTO.convert(orderForm);
        System.out.println(orderDTO);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
           log.error("【创建订单】购物车不能为空");
           throw new SellException(ResultEnum.CART_EMPTY);
       }
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtils.success();

    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(
            @RequestParam("openid")String openid
            ,@RequestParam(value = "page",defaultValue = "0")Integer page
            ,@RequestParam(value = "size",defaultValue = "5")Integer size){
    if (StringUtils.isEmpty(openid)){
        log.error("【查询订单列表】openid不能为空");
        throw new SellException(ResultEnum.PARAM_ERROR);
    }
        PageRequest request = PageRequest.of(page, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVOUtils.success(orderDTOPage.getContent());

    }



    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(
            @RequestParam("openid")String openid,
            @RequestParam("orderId")String orderId){
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtils.success(orderOne);
    }
    //取消订单
    @PutMapping("/cancel")
    public ResultVO cancel(
            @RequestParam("openid")String openid,
            @RequestParam("orderId")String orderId){
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtils.success();


    }

}
