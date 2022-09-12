package com.ssm.book.controller;

import com.ssm.book.pojo.Book;
import com.ssm.book.pojo.User;
import com.ssm.book.service.BookService;
import com.ssm.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loginController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginToIndex(String uname, String pwd, Model model, HttpSession session) {
        User user = userService.checkUser(uname, pwd);
        if (user != null) {
            model.addAttribute("currentUser", user);
            session.setAttribute("user", user);
            return "/login_success";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model/*@PathVariable("pageNum") Integer pageNum*/) {
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
       /* PageInfo<Book> pageInfo = bookService.getBookPage(pageNum);
        model.addAttribute("page",pageInfo);*/
        return "/index";
    }

    @RequestMapping(value = "/destory", method = RequestMethod.GET)
    public String destory() {
        return "/destory";
    }
}
