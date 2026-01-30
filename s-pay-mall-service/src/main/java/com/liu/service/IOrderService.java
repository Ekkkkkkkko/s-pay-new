package com.liu.service;

import com.liu.domain.req.ShopCartReq;
import com.liu.domain.res.PayOrderRes;

/**
 * @author Ekko
 * @description 订单服务接口
 * @create 2026/1/30 12:27
 */
public interface IOrderService {

    PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception;

}
