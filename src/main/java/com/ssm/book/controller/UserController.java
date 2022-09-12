package com.ssm.book.controller;

import com.ssm.book.pojo.OrderBean;
import com.ssm.book.pojo.User;
import com.ssm.book.service.OrderService;
import com.ssm.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String checkOutIndex(HttpSession session){
        OrderBean orderBean = new OrderBean();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nowStr = simpleDateFormat.format(date);
        String[] split = nowStr.split("-");
        String dateStr="";
        for (int i = 0; i < split.length; i++) {
            dateStr+=split[i];
        }
        orderBean.setOrderNo(UUID.randomUUID().toString()+dateStr);
        orderBean.setOrderDate(date);
        User user =(User) session.getAttribute("user");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return "/checkOutIndex";
    }
}
