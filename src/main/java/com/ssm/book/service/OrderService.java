package com.ssm.book.service;


import com.ssm.book.pojo.OrderBean;
import com.ssm.book.pojo.User;

import java.util.List;

public interface OrderService {

    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);
}
