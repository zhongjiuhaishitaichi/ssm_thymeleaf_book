package com.ssm.book.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.book.pojo.Book;
import com.ssm.book.service.BookService;
import com.ssm.book.service.CartItemService;
import com.ssm.book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/houtai",method = RequestMethod.GET)
    public String manager(){
        return "/houtai";
    }

    @RequestMapping(value = "/bookManage/{pageNum}",method = RequestMethod.GET)
    public String bookManage( Model model,@PathVariable("pageNum") Integer pageNum){
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        PageInfo<Book> pageInfo = bookService.getBookPage(pageNum);
        model.addAttribute("page",pageInfo);
        return "/book_manager";
    }
    @RequestMapping(value = "/orderManage",method = RequestMethod.GET)
    public  String orderManage(){
        return "/order_manager";
    }

    @RequestMapping(value = "/deleteOne/{id}", method = RequestMethod.GET)
    public String deleteSimple(@PathVariable("id") Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/bookManage/1";
    }
    @RequestMapping(value = "/bookEdit",method = RequestMethod.GET)
    public String addBookIndex(){
        return "/book_edit";
    }
    @RequestMapping(value = "/edit_book",method = RequestMethod.POST)
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/bookManage/1";
    }
}
