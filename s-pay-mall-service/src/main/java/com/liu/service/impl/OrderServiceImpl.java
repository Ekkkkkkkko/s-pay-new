package com.liu.service.impl;

import com.liu.common.constants.Constants;
import com.liu.dao.IOrderDao;
import com.liu.domain.po.PayOrder;
import com.liu.domain.req.ShopCartReq;
import com.liu.domain.res.PayOrderRes;
import com.liu.domain.vo.ProductVO;
import com.liu.service.IOrderService;
import com.liu.service.rpc.ProductRPC;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;


import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ekko
 * @description
 * @create 2026/1/30 13:37
 */
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderDao orderDao;
    @Resource
    private ProductRPC productRPC;
    @Override
    public PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception {
        //1、查询当前用户是否存在未支付订单或者掉单
        PayOrder payOrderReq =new PayOrder();
        payOrderReq.setUserId(shopCartReq.getUserId());
        payOrderReq.setProductId(shopCartReq.getProductId());
        PayOrder unpaidOrder=orderDao.queryUnPayOrder(payOrderReq);

        if (null!=unpaidOrder&& Constants.OrderStatusEnum.PAY_WAIT.getCode().equals((unpaidOrder.getStatus()))){
            log.info("创建订单-存在，已存在未支付订单。userId:{} productId:{}orderId:{}",shopCartReq.getUserId(),shopCartReq.getProductId(),unpaidOrder.getOrderId());
            return PayOrderRes.builder()
                    .orderId(unpaidOrder.getOrderId())
                    .payUrl(unpaidOrder.getPayUrl())
                    .build();
        } else if (null!=unpaidOrder&&Constants.OrderStatusEnum.CREATE.getCode().equals(unpaidOrder.getStatus())) {
            //todo
        }

        ProductVO productVO=productRPC.queryProductByProductId(shopCartReq.getProductId());
        String orderId = RandomStringUtils.randomNumeric(16);
        orderDao.insert(PayOrder.builder()
                .userId(shopCartReq.getUserId())
                .productId(shopCartReq.getProductId())
                .productName(productVO.getProductName())
                .orderId(orderId)
                .totalAmount(productVO.getPrice())
                .orderTime(new Date())
                .status(Constants.OrderStatusEnum.CREATE.getCode())
                .build());

        return PayOrderRes.builder()
                .orderId(orderId)
                .payUrl("暂无")
                .build();
    }
}
