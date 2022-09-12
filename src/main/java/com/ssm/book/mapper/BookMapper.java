package com.ssm.book.mapper;


import com.ssm.book.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> getBookList();

    Book getBookById(@Param("id") Integer id);

    void deleteBookById(@Param("id") Integer id);

    void addBook(Book book);
}
