package com.ssm.book.service.impl;


import com.ssm.book.mapper.CartMapper;
import com.ssm.book.mapper.OrderItemMapper;
import com.ssm.book.mapper.OrderMapper;
import com.ssm.book.pojo.CartItem;
import com.ssm.book.pojo.OrderBean;
import com.ssm.book.pojo.OrderItem;
import com.ssm.book.pojo.User;
import com.ssm.book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private CartMapper cartMapper;
    @Override
    public void addOrderBean(OrderBean orderBean) {
         orderMapper.addOrderBean(orderBean);
        User user = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();
        for (CartItem cartItem :cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemMapper.addOrderItem(orderItem);
        }
        for (CartItem cartItem :cartItemMap.values()) {
            cartMapper.deleteCartItemById(cartItem.getId());
        }
    }
    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList =orderMapper.getOrderList(user);
        for (OrderBean  orderBean : orderBeanList) {
            orderBean.setOrderUser(user);
            Integer totalBookCount = orderMapper.getOrderTotalBookCount(orderBean);//每一个订单的总数
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList;
    }
}
