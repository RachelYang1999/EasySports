package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.Playground;
import com.elec5619.easysports.domain.VisitRecord;
import com.elec5619.easysports.service.HistoryService;
import com.elec5619.easysports.service.PlaygroundService;
import com.elec5619.easysports.utility.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SearchHistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PlaygroundService playgroundService;
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/viewSearchHistory", method = RequestMethod.GET)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String View(Model model) throws IOException {
//        List<Playground> playgroundList = playgroundService.findAllPlayground();
        List<VisitRecord> vrList = new ArrayList<>();
        if(SessionUtil.getCurrentUser() != null){
            vrList = historyService.findAllByProperty("userId", SessionUtil.getCurrentUser().getId());
        }
        List<VisitRecord> newVRList = new ArrayList<VisitRecord>();
        List<Playground> myPlaygroundList = new ArrayList<Playground>();
        if(vrList.size() > 10){
            for(int i = vrList.size() - 1; i > vrList.size() - 11; i--){
                newVRList.add(vrList.get(i));
            }
        }
        else{
            newVRList.addAll(vrList);
        }

        for(VisitRecord vr: newVRList){
            Playground p = playgroundService.getById(vr.getPlaygroundId());
            System.out.println("search controller create time: "+vr.getCreateTime());
            p.setVisitedTime(vr.getCreateTime().toString());
            myPlaygroundList.add(p);
        }

        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }

        String jsonArray = playgroundService.getPlaygroundJson(myPlaygroundList);
        model.addAttribute("history", jsonArray);
        return "viewSearchHistory"; //return viewSearchResult.jsp
    }

    @RequestMapping(value = "/viewSearchHistory", method = RequestMethod.POST)// define a request mapping, value is requested url ("/"), method defines request type (Get/Post)
    public String getPlayground_id(@RequestParam("playgroundid")String playground_id, @RequestParam("selectedDay")String selectedDay, Model model, HttpServletRequest request) {
        VisitRecord vr = new VisitRecord();
        vr.setPlaygroundId(Integer.parseInt(playground_id));
        if(SessionUtil.getCurrentUser() != null) {
            vr.setUserId(SessionUtil.getCurrentUser().getId());
        }
        vr.setCreateTime(new Date());
        historyService.addToHistory(vr);

        model.addAttribute("id",playground_id );
        request.getSession().setAttribute("playground", playground_id);
        if(SessionUtil.getCurrentUser() != null) {
            model.addAttribute("userName", SessionUtil.getCurrentUser().getUsername());
        }
        model.addAttribute("selectedDay", selectedDay);

        return "redirect:/playground";
    }

}