package com.liu.service;

import com.liu.domain.req.ShopCartReq;
import com.liu.domain.res.PayOrderRes;

import java.util.List;

/**
 * @author Ekko
 * @description 订单服务接口
 * @create 2026/1/30 12:27
 */
public interface IOrderService {

    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

    void changeOrderPaySuccess(String orderId);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);
}
