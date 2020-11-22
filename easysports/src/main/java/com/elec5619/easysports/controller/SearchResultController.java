package com.elec5619.easysports.controller;


import com.elec5619.easysports.domain.*;
import com.elec5619.easysports.service.FavouriteService;

import com.elec5619.easysports.service.HistoryService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.service.TimePeriodService;
import com.elec5619.easysports.utility.MapAPI;
import com.elec5619.easysports.utility.SessionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchResultController {

    @Autowired
    private PlaygroundService playgroundService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TimePeriodService timePeriodService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private  FavouriteService favouriteService;

    private Map<String, String> key_type = new HashMap(){{
        put("1", "Basketball");
        put("2", "Badminton");
        put("3", "Baseball");
        put("4", "Swimming");
        put("5", "Tennis");
        put("6", "Others");
    }};

    private Map<String, Integer> max_distance = new HashMap(){{
        put("1", 2);
        put("2", 5);
        put("3", 10);
        put("4", 20);
    }};


    @RequestMapping(value = "/viewSearchResult", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String View(@RequestParam("playgroundType")String playgroundType, @RequestParam("preferredDay")String preferredDay, @RequestParam("preferredDistance")String preferredDistance, Model model) throws IOException, ParseException, InterruptedException, ApiException {
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        System.out.println("playgroundType: " + playgroundType + "\npreferredDay: " + preferredDay + "\npreferredDistance: " + preferredDistance);

        List<Playground> recomList = new ArrayList<>();  //recommend list
        List<Favourite> favList = new ArrayList<>();
        if(SessionUtil.getCurrentUser()!= null) {
            favList = favouriteService.getFavouritesByUserId(SessionUtil.getCurrentUser().getId());
        }
        List<Favourite> allList = favouriteService.getAllFav();
        List<Integer> fReUserId = new ArrayList<>();
        for (Favourite item: allList){
            for(Favourite fitem: favList){
                if(item.getUserId() != fitem.getUserId() && item.getPlaygroundId() == fitem.getPlaygroundId()){
                    if(!fReUserId.contains(item.getUserId())){
                        fReUserId.add(item.getUserId()); // same user id;
                    }
                }
            }
        }
        List<Integer> fPlayId = new ArrayList<>();
        for(Favourite item: allList){
            if(fReUserId.contains(item.getUserId())){
                if(!fPlayId.contains(item.getPlaygroundId())){
                    fPlayId.add(item.getPlaygroundId());
                }
            }
        }
        List<Playground> allPlayList = playgroundService.findAllPlayground();
        for (Playground item: allPlayList){
            if(fPlayId.contains(item.getId())){
                if(!recomList.contains(item)){
                    recomList.add(item);
                }
            }
        }

        List<Playground> playgroundList = new ArrayList<>();
        List<TimePeriod> timePeriodList = timePeriodService.findAllByTwoProperty("day", preferredDay, "isAvailable", true);
        String type = key_type.get(playgroundType);
        String[] origins = {};
        if(SessionUtil.getCurrentUser()!= null) {
            if(SessionUtil.getCurrentUser().getAddress() != null) {
                origins = new String[]{SessionUtil.getCurrentUser().getAddress()};
            }
        }

        if(playgroundType.equals("Choose...") && preferredDistance.equals("Choose...")){
            if(timePeriodList.size() > 0) {
                for(TimePeriod timePeriod: timePeriodList) {
                    Playground temp = playgroundService.getById(timePeriod.getPlaygroundId());
                    if(!playgroundList.contains(temp)) {
                        playgroundList.add(temp);
                    }
                }
            }

            List<Playground> noBookings = playgroundService.findAllByProperty("bookingRequired", false);
            playgroundList.addAll(noBookings);
            if(origins.length!=0 && playgroundList.size()!= 0) {
                playgroundList = MapAPI.calDistanceHelper(origins, playgroundList, playgroundService);
            }
        }

        if(playgroundType.equals("Choose...") && !preferredDistance.equals("Choose...")) {
            if(timePeriodList.size() > 0) {
                for(TimePeriod timePeriod: timePeriodList) {
                    Playground temp = playgroundService.getById(timePeriod.getPlaygroundId());
                    if(!playgroundList.contains(temp)) {
                        playgroundList.add(temp);
                    }
                }
            }
            List<Playground> noBookings = playgroundService.findAllByProperty("bookingRequired", false);
            playgroundList.addAll(noBookings);

            if(origins.length!=0 && playgroundList.size()!= 0) {
                playgroundList =  MapAPI.calDistance(origins, playgroundList, playgroundService, max_distance.get(preferredDistance));
            }

        }

        if(!playgroundType.equals("Choose...") && preferredDistance.equals("Choose...")) {
            List<Playground> noBookings = playgroundService.findAllByProperty("bookingRequired", false);
            for(Playground temp: noBookings) {
                if(temp.getType().equals(type)&&!playgroundList.contains(temp)) {
                    playgroundList.add(temp);
                }
            }

            if(timePeriodList.size() > 0) {
                for(TimePeriod timePeriod: timePeriodList) {
                    Playground temp = playgroundService.getById(timePeriod.getPlaygroundId());
                    if(temp.getType().equals(type)&&!playgroundList.contains(temp)) {
                        playgroundList.add(temp);
                    }
                }
            }

            if(origins.length!=0 && playgroundList.size()!= 0) {
                playgroundList = MapAPI.calDistanceHelper(origins, playgroundList, playgroundService);
            }
        }

        if(!playgroundType.equals("Choose...") && !preferredDistance.equals("Choose...")) {
            List<Playground> noBookings = playgroundService.findAllByProperty("bookingRequired", false);
            for(Playground temp: noBookings) {
                if(temp.getType().equals(type)&&!playgroundList.contains(temp)) {
                    playgroundList.add(temp);
                }
            }

            if(timePeriodList.size() > 0) {
                for(TimePeriod timePeriod: timePeriodList) {
                    Playground temp = playgroundService.getById(timePeriod.getPlaygroundId());
                    if(temp.getType().equals(type)&&!playgroundList.contains(temp)) {
                        playgroundList.add(temp);
                    }
                }
            }


            if(origins.length!=0 && playgroundList.size()!= 0) {
                playgroundList =  MapAPI.calDistance(origins, playgroundList, playgroundService, max_distance.get(preferredDistance));
            }

        }

        if(playgroundList.size() == 0) {
            model.addAttribute("message", "Sorry there is no suitable result.");
            return "viewSearchResult";
        }
        for(Playground playground : playgroundList) {
            System.out.println(playground.toString());
        }
        String jsonArray = playgroundService.getPlaygroundJson(playgroundList);
        String jsonArray2 = playgroundService.getPlaygroundJson(recomList);

        model.addAttribute("playgrounds", jsonArray);
        model.addAttribute("recomlist", jsonArray2);

        model.addAttribute("message", "Here are all the suitable results. If you did not enter your address in your profile, all distances will be 0km.");
        model.addAttribute("selectedDay", preferredDay);
        return "viewSearchResult"; //return viewSearchResult.jsp
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String ViewPost(@RequestParam("playgroundType")String playgroundType, @RequestParam("preferredDay")String preferredDay, @RequestParam("preferredDistance")String preferredDistance, Model model) {
        if(SessionUtil.getCurrentUser()!= null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("playgroundType", playgroundType);
        model.addAttribute("preferredDay", preferredDay);
        model.addAttribute("preferredDistance", preferredDistance);
        return "redirect:/viewSearchResult"; //return viewSearchResult.jsp
    }

    @RequestMapping(value = "/viewSearchResult", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String getPlayground_id(@RequestParam("playgroundid")String playground_id,@RequestParam("selectedDay")String selectedDay, Model model) {
        VisitRecord vr = new VisitRecord();
        vr.setPlaygroundId(Integer.parseInt(playground_id));
        if(SessionUtil.getCurrentUser() != null) {
            vr.setUserId(SessionUtil.getCurrentUser().getId());
        }
        vr.setCreateTime(new Date());
        historyService.addToHistory(vr);
        System.out.println(playground_id+"!!!!!!");

        model.addAttribute("id",playground_id );
        request.getSession().setAttribute("playground", playground_id);
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("selectedDay", selectedDay);

        return "redirect:/playground";
    }

}