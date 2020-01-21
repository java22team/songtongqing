package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Book;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {



        return userMapper.findAll();
    }

    @Override
    public List<Book> findAllBook(Integer pageNum ,Integer pageSize) {


        PageHelper.startPage(pageNum,pageSize);
        return userMapper.findAllBook();
    }

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }
}
