package com.city.oa.controller;


import com.city.oa.VO.ProductInfoVO;
import com.city.oa.VO.ProductVO;
import com.city.oa.VO.ResultVO;
import com.city.oa.bean.ProductCategory;
import com.city.oa.bean.ProductInfo;
import com.city.oa.service.CategoryService;
import com.city.oa.service.ProductInfoService;
import com.city.oa.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品相关东西 如买家下订单加购物车
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResultVO list(){
        //1 查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll(); //4个对象
        //2 查询类别 一次查询
        //List<Integer> categoryList = new ArrayList<>();
        //java8 lamba
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(p -> p.getProductType())
                .collect(Collectors.toList());
        //System.out.println(categoryTypeList);
        List<ProductVO> productVOList=new ArrayList<>(); //最外层 包括每一类有多少
        List<ProductCategory> productCategoryList = categoryService.findAllByCategoryTypeIn(categoryTypeList);
        System.out.println(productCategoryList);//返回所有类别
        //3 数据拼装
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getProductType().equals(productCategory.getCategoryType())){
                    //System.out.println(productInfo);
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return  ResultVOUtils.success(productVOList);
        /*ResultVO resultVO=new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");*/

       /* //状态码
        ResultVO resultVO=new ResultVO();

        //类别
        ProductVO productVO = new ProductVO();
        //该类别 详细列表 即一种类别有多个列表
        ProductInfoVO productInfoVO = new ProductInfoVO();
        resultVO.setData(Arrays.asList(productVO));//多种类别
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO)); //每种类别的详情*/

    }

}
