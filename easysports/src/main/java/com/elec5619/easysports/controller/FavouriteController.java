package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.Favourite;
import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.service.FavouriteService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.utility.LoginUser;
import com.elec5619.easysports.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FavouriteController {
    @Autowired
    private FavouriteService favouriteService;
    @Autowired
    private PlaygroundService playgroundService;
   @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "/viewFavourite", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String View(Model model) throws IOException {
        List<Favourite> favouriteList = new ArrayList<>();

        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());

            LoginUser loginUser = (LoginUser) (request.getSession().getAttribute("loginUser"));
            favouriteList = favouriteService.getFavouritesByUserId(loginUser.getId());
        }



        if(favouriteList.size() == 0) {
            model.addAttribute("message", "Sorry there is no suitable results.");
            return "viewFavourite";
        }

        List<Playground> playgroundList = new ArrayList<>();
        for(Favourite favourite: favouriteList) {
            Playground temp = playgroundService.getById(favourite.getPlaygroundId());
            if(!playgroundList.contains(temp)) {
                playgroundList.add(temp);
            }
        }

        String jsonArray = playgroundService.getPlaygroundJson(playgroundList);
        model.addAttribute("playgrounds", jsonArray);
        model.addAttribute("message", "Here are all the favourite playgrounds.");
        return "viewFavourite"; //return viewFavourite.jsp
    }

    @RequestMapping(value = "/viewFavourite", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String getPlayground_id(@RequestParam("playgroundid")String playground_id, Model model) {
        System.out.println(playground_id+"!!!!!!");
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String date = format.format(new Date());
        model.addAttribute("id",playground_id );
        request.getSession().setAttribute("playground", playground_id);

        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("selectedDay", date);

        return "redirect:/playground";
    }

    @RequestMapping(value = "/deleteFavourite", method = RequestMethod.POST)
    public String DeleteFavourite(@RequestParam("playgroundid")int playgroundId, Model model){
        LoginUser loginUser = (LoginUser) (request.getSession().getAttribute("loginUser"));
        List<Favourite> favouriteList = favouriteService.getFavouritesByUserId(loginUser.getId());

        Favourite targetFavour = null;
        for(Favourite favourite: favouriteList) {
            if (favourite.getPlaygroundId() == playgroundId){
                targetFavour = favourite;
                break;
            }
        }

        if (targetFavour == null) {
            model.addAttribute("message", "Sorry there is no suitable result to delete.");
        }
        else {
            favouriteService.deleteFavourite(targetFavour.getId());
            //model.addAttribute("message", "Delete the specify favourite item successfully.");
        }

        return "redirect:/viewFavourite";
    }

    @RequestMapping(value = "/deleteFavour", method = RequestMethod.POST)
    @ResponseBody
    public String DeleteFavour(@RequestParam("playgroundid")int playgroundId){
        LoginUser loginUser = (LoginUser) (request.getSession().getAttribute("loginUser"));
        List<Favourite> favouriteList = favouriteService.getFavouritesByUserId(loginUser.getId());

        Favourite targetFavour = null;
        for(Favourite favourite: favouriteList) {
            if (favourite.getPlaygroundId() == playgroundId){
                targetFavour = favourite;
                break;
            }
        }

        if (targetFavour == null) {
            return "Sorry there is no suitable result to delete.";
        }
        else {
            favouriteService.deleteFavourite(targetFavour.getId());
            return "Success";
        }
    }

    @RequestMapping(value = "/addFavourite", method = RequestMethod.POST)
    @ResponseBody
    public String AddFavourite(HttpServletRequest request){
        String playgroundIdStr = request.getParameter("playgroundId");
        int playgroundId = Integer.parseInt(playgroundIdStr);
        LoginUser loginUser = SessionUtil.getCurrentUser();

        List<Favourite> favouriteList = favouriteService.getFavouritesByUserId(loginUser.getId());

        Favourite targetFavour = null;
        for(Favourite favourite: favouriteList) {
            if (favourite.getPlaygroundId() == playgroundId){
                targetFavour = favourite;
                break;
            }
        }

        if (targetFavour == null) {
            Favourite insertFavour = new Favourite();
            insertFavour.setCreateTime(new Date());
            insertFavour.setPlaygroundId(playgroundId);
            insertFavour.setUserId(loginUser.getId());
            favouriteService.insert(insertFavour);

            return "Success";
        }
        else {
            favouriteService.deleteFavourite(targetFavour.getId());
            return "You have already like this playground!";
        }
    }

    @RequestMapping(value = "/checkFavourite", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkFavourite(@RequestParam("playgroundId")int playgroundId){
        LoginUser loginUser = SessionUtil.getCurrentUser();

        List<Favourite> favouriteList = favouriteService.getFavouritesByUserId(loginUser.getId());

        Favourite targetFavour = null;
        for(Favourite favourite: favouriteList) {
            if (favourite.getPlaygroundId() == playgroundId){
                targetFavour = favourite;
                break;
            }
        }

        if (targetFavour == null) {
           return false;
        }
        else {
            return true;
        }
    }
}
