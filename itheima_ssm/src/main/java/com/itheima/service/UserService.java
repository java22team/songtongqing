package com.itheima.service;

import com.itheima.domain.Book;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<Book> findAllBook(Integer pageNum ,Integer pageSize);

    User login(String username, String password);
}
