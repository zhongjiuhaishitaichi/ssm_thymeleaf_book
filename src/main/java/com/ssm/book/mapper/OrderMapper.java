package com.ssm.book.mapper;

import com.ssm.book.pojo.OrderBean;
import com.ssm.book.pojo.User;

import java.util.List;

public interface OrderMapper {

   void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);

    Integer getOrderTotalBookCount(OrderBean orderBean);
}
