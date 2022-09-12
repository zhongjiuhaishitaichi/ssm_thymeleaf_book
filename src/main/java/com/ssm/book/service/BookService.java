package com.ssm.book.service;


import com.github.pagehelper.PageInfo;
import com.ssm.book.pojo.Book;

import java.util.List;

public interface BookService {


    List<Book> getBookList();

     PageInfo<Book> getBookPage(Integer pageNum);

    void deleteBookById(Integer id);

    void addBook(Book book);
}
