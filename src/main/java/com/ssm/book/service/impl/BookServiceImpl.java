package com.ssm.book.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.book.mapper.BookMapper;
import com.ssm.book.pojo.Book;
import com.ssm.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public PageInfo<Book> getBookPage(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Book> bookList = bookMapper.getBookList();
        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList, 3);
        System.out.println(bookPageInfo);
        return bookPageInfo;
    }

    @Override
    public void deleteBookById(Integer id) {
        bookMapper.deleteBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

}
