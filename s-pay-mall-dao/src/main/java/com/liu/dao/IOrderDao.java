package com.liu.dao;

import com.liu.domain.po.PayOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ekko
 * @description
 * @create 2026/1/30 13:04
 */
@Mapper
public interface IOrderDao {

    void insert(PayOrder payOrder);

    PayOrder queryUnPayOrder(PayOrder payOrder);

}
