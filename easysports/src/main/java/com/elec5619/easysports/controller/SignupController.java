package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.utility.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class SignupController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup"; //return signup.jsp
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signup(@RequestParam("userName")String userName, @RequestParam("email")String email, @RequestParam("password")String password,
                               @RequestParam("confirmPassword")String confirmPassword, @RequestParam("securityQuestion")String question,
                               @RequestParam("answer")String answer) throws DuplicateKeyException {
        if(!password.equals(confirmPassword)) {
            return new ModelAndView("signup","message","Your password is not same.");
        }
        if(userService.findByEmail(email) != null) {
            return new ModelAndView("signup","message","Sorry, this email have been registered. You can signup with other email or directly login");
        }
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(SHA256Util.getSHA256(password));
        user.setCreateTime(new Date());
        user.setSecurityQuestion(question);
        user.setAnswer(SHA256Util.getSHA256(answer));
        user.setType("normal");
        System.out.println(user.toString());
        userService.insert(user);  //view -> controller -> service -> Dao -> database
        return new ModelAndView("redirect:/login","message","Successfully Registered");
    }
}
