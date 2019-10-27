package com.city.oa.service.impl;

import com.city.oa.bean.ProductInfo;
import com.city.oa.dto.CartDTO;
import com.city.oa.enums.ProductStatusEnum;
import com.city.oa.enums.ResultEnum;
import com.city.oa.exception.SellException;
import com.city.oa.mapper.ProductInfoMapper;
import com.city.oa.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //注入dao
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public Optional<ProductInfo> findById(String productId) {
        return productInfoMapper.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findByProductStatus(ProductStatusEnum.UP.getCode());

    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoMapper.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoMapper.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        //循环购物车这个对象获取productId返回商品列表
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo= productInfoMapper.getOne(cartDTO.getProductId());
            if (productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoMapper.save(productInfo);


        }
    }
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfo = productInfoMapper.findById(cartDTO.getProductId());
            if (productInfo.get()==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
          Integer  result= productInfo.get().getProductStock()-cartDTO.getProductQuantity();

            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);
            productInfoMapper.save(productInfo.get());
        }

    }
}
