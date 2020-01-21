package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Book;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/f")
    public List<User> findAll(){

        return userService.findAll();
    }
//查询所有书籍
    @RequestMapping(value = "/findAllBook")
    public String findAllBook(Model model,
                              @RequestParam(value = "pageNum" ,required = false ,defaultValue = "1") Integer pageNum ,
                              @RequestParam(value = "pageSize" ,required = false ,defaultValue = "10")Integer pageSize){

        List<Book>  bk= userService.findAllBook(pageNum,pageSize);
        PageInfo<Book> pageInfo=new PageInfo<Book>(bk);



              model.addAttribute("pageInfo",pageInfo);


//        request.getSession().setAttribute("bookList",bk);
        return "/book_list.jsp";
    }

//    登录
    @RequestMapping("/login")
    public String login(@Param("username")String username, @Param("password")String password, Model model, HttpServletRequest request){

        System.out.println(username);

       User uu= userService.login(username,password);
      //  System.out.println(uu);
       if (uu!=null){
           //存到session给拦截器判断是否登录
           request.getSession().setAttribute("user",uu);
           return "/user/findAllBook";
       }else {

           return "/login.jsp";
       }


    }
}
