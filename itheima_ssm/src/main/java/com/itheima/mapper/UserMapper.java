package com.itheima.mapper;


import com.itheima.domain.Book;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Resource//注解方式
public interface UserMapper {
    List<User>  findAll();
    List<Book> findAllBook();

   // @Select("select * from USER  where username = #{username} and password =#{password}")
    User login(@Param("username") String username, @Param("password") String password);
}
