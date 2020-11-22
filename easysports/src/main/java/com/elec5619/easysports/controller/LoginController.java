package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.utility.LoginUser;
import com.elec5619.easysports.utility.MapAPI;
import com.elec5619.easysports.utility.SHA256Util;
import com.elec5619.easysports.utility.SessionUtil;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class LoginController {
    //    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserService userService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login"; //return login.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpServletRequest
            request) {

        User user = userService.findByEmail(email);
        if(user != null &&  user.getPassword().equals(SHA256Util.getSHA256(password))){
            LoginUser loginUser = new LoginUser();
            loginUser.setEmail(email);
            loginUser.setId(user.getId());
            loginUser.setType(user.getType());
            loginUser.setUsername(user.getUserName());
            if(user.getAddress() != null) {
                loginUser.setAddress(user.getAddress());
            }
            request.getSession().setAttribute("loginUser", loginUser);
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());

            return "redirect:/welcome";
        }
        model.addAttribute("message", "Enter Correct details...");

        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome( Model model){
        if(SessionUtil.getCurrentUser()!= null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        return "welcome";
    }

    public void testuser(UserService userService){
        this.userService=userService;
    }
}
