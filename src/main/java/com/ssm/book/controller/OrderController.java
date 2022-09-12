package com.ssm.book.controller;

import com.ssm.book.pojo.OrderBean;
import com.ssm.book.pojo.User;
import com.ssm.book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String orderIndex(HttpSession session, Model model){
        User user =(User) session.getAttribute("user");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("user",user);
        model.addAttribute("orderList",orderList);
        return "/order";
    }
}
