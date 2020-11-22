
package com.elec5619.easysports.controller;


import com.elec5619.easysports.dao.impl.PlaygroundDaoImpl;
import com.elec5619.easysports.domain.Comment;
import com.elec5619.easysports.service.CommentService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.utility.SessionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@Controller
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    private PlaygroundService playgroundService;



    /**
     * Simply selects the home view to render by returning its name.
     */

    @RequestMapping(value = "/viewComments", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String viewComments(Model model) throws IOException {
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
            model.addAttribute("comment", commentService.getAllComments(SessionUtil.getCurrentUser().getId()));
        }
        return "viewComments";
    }

    @RequestMapping("/submitComment")
    @ResponseBody
    public Comment sendComment(@RequestParam("description") String description, HttpServletRequest request){
        System.out.println("return" + description);
        int playgroundID = Integer.parseInt(SessionUtil.getcurplayground());
        Date date = new Date();
        int userID = SessionUtil.getCurrentUser().getId();
        Comment comment = new Comment();
        comment.setCreateTime(date);
        comment.setDescription(description);
        comment.setUserId(userID);
        comment.setPlaygroundId(playgroundID);
        comment.setName(playgroundService.getById(comment.getPlaygroundId()).getName());
        commentService.insert(comment);
        return comment;
    }

//    @RequestMapping(value = "/playground", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
//    public String viewCommentsByPlayground(Model model) throws IOException {
//        if(SessionUtil.getCurrentUser() != null) {
//            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
//            model.addAttribute("comment", commentService.getCommentsByPlayground(Integer.parseInt(SessionUtil.getcurplayground())));
//        }
//        return "playground";
//    }



}