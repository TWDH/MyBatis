package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //分页管理
        //pageNum:页码值；pageSize：每页显示条数
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(int ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }
}
