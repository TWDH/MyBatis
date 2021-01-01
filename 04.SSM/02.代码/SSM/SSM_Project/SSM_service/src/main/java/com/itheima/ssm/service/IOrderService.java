package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(int ordersId) throws Exception;
}
