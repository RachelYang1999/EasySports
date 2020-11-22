package com.elec5619.easysports.controller;


import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.utility.LoginUser;
import com.elec5619.easysports.utility.SHA256Util;
import com.elec5619.easysports.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PasswordController {
    @Autowired
    private UserService userService;
    User user = new User();
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword(Model model) {
        return "forgotPassword"; //return forgotPassword.jsp
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String forgotPassword(@RequestParam("email") String email, Model model) {

        User validating = userService.findByEmail(email);
        if (validating == null) {
            model.addAttribute("message", "Your email is wrong, please try again");
            return "forgotPassword"; //If the answer is wrong, return to forgotPassword.jsp
        } else {
            this.user = validating;
            return "redirect:/verifySecurityAnswer"; //redirect to the verify-answer page
        }
    }

    public String getQuestion(String questionId) {
        String question = "Sorry, your question is not found :(";
        if (questionId == null) {
            return question;
        }
        switch (questionId) {
            case "1":
                question = "Where is your birth place?";
                break;
            case "2":
                question = "When is your birthday?";
                break;
            case "3":
                question = "Where is your mother's birth place?";
                break;
            case "4":
                question = "Where is your father's birth place?";
                break;
        }
        return question;
    }

    @RequestMapping(value = "/verifySecurityAnswer", method = RequestMethod.GET)
    public String verifySecurityAnswer(Model model) {

        String questionId = user.getSecurityQuestion();
        model.addAttribute("question", getQuestion(questionId));
        return "verifySecurityAnswer"; //return verifySecurityAnswer.jsp
    }

    @RequestMapping(value = "/verifySecurityAnswer", method = RequestMethod.POST)
    public String verifySecurityAnswer(@RequestParam("answer") String answer, Model model) {

        String correctAnswer = user.getAnswer();
        if (correctAnswer == null) {
            model.addAttribute("message", "Cannot find this account");
            return "verifySecurityAnswer";
        }
        if (!correctAnswer.equals(SHA256Util.getSHA256(answer))) {
            model.addAttribute("question", getQuestion(this.user.getSecurityQuestion()));
            model.addAttribute("message", "Your answer is wrong, please try again");
            return "verifySecurityAnswer";
        } else {
            return "redirect:/changePasswordVerified"; //redirect to the change password page that no need to enter the old password
        }
    }

    @RequestMapping(value = "/changePasswordVerified", method = RequestMethod.GET)
    public String changePasswordVerified() {
        return "changePasswordVerified"; //change password page that no need to enter the old password
    }

    @RequestMapping(value = "/changePasswordVerified", method = RequestMethod.POST)
    public String changePasswordVerified(@RequestParam("newPassword") String newPassword,
                                         @RequestParam("verifyPassword") String verifyPassword, Model model) {
        if (newPassword.equals(verifyPassword)) {
            user.setPassword(SHA256Util.getSHA256(verifyPassword));
            userService.update(user);
            model.addAttribute("message", "You have changed the password successfully, please login again!");
            return "redirect:/afterChangePassword";
        } else {
            model.addAttribute("message", "Two passwords are not the same, please try again!");
            return "changePasswordVerified";
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePassword(Model model) {
        if (SessionUtil.getCurrentUser() == null) {
            return "redirect:/login";
        }
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        return "changePassword"; //return forgotPassword.jsp
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@RequestParam("previousPassword") String previousPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("verifyPassword") String verifyPassword,
                                 Model model) {
        LoginUser currentLoginUser = SessionUtil.getCurrentUser();
        if (currentLoginUser == null) {
            model.addAttribute("message", "You are currently not logged in, please log in first to proceed.");
            return "redirect:/login"; //Redirect to login page
        }
        User currentUser = userService.findByEmail(currentLoginUser.getEmail());
        model.addAttribute("userName", currentUser.getUserName());

        if(SessionUtil.getCurrentUser() != null) {
            currentUser = userService.findByEmail(currentLoginUser.getEmail());
            model.addAttribute("userName", currentUser.getUserName());
        }


        if (previousPassword == null) {
            model.addAttribute("message", "Previous password cannot be empty");
        }

        if (newPassword == null) {
            model.addAttribute("message", "New password cannot be empty");
        }

        this.user = currentUser;
        if (previousPassword != null && newPassword != null) {
            if (this.user.getPassword().equals(SHA256Util.getSHA256(previousPassword))) {
                if (newPassword.equals(verifyPassword)) {
                    user.setPassword(SHA256Util.getSHA256(verifyPassword));
                    userService.update(user);
                    model.addAttribute("message", "You have changed the password successfully, please login again!");
                    return "redirect:/afterChangePassword";
                } else {
                    model.addAttribute("message", "Two passwords are not the same, please try again!");
                }
            } else {
                model.addAttribute("message", "Wrong previous password :(");
            }
        }
        return "changePassword"; //If the previous password is wrong, return to changePassword.jsp
    }

    @RequestMapping(value = "/afterChangePassword", method = RequestMethod.GET)
    public String afterChangePassword(Model model) {
        return "afterChangePassword";
    }
}
