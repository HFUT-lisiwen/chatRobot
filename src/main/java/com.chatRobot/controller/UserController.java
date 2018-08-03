package com.chatRobot.controller;

import javax.servlet.http.HttpServletRequest;

import com.chatRobot.model.User;
import com.chatRobot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("--------id1="+request.getParameter("id1"));
        System.out.println("--------id2="+request.getParameter("id2"));
        long userId1 = Long.parseLong(request.getParameter("id1"));
        long userId2 = Long.parseLong(request.getParameter("id2"));
        System.out.println("--------userId1="+userId1);
        System.out.println("--------userId2="+userId2);
        User user1 = this.userService.selectUser(userId1);
        System.out.println("--------user1="+user1);
        User user2 = this.userService.selectUser(userId2);
        System.out.println("--------user2="+user2);
        System.out.println("--------user2.name="+user2.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user1));
        response.getWriter().write(mapper.writeValueAsString(user2));
        response.getWriter().close();
    }

}