package com.elec5619.easysports.controller;

import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import com.elec5619.easysports.utility.LoginUser;
import com.elec5619.easysports.utility.MapAPI;
import com.elec5619.easysports.utility.SessionUtil;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    User user = new User();

    public Boolean verifyCurrentSession() {
        if (SessionUtil.getCurrentUser() == null) {
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
    public String viewProfile(Model model) {
        if (SessionUtil.getCurrentUser() == null) {
            return "redirect:/login";
        }
        User currentUser = new User();
        if(SessionUtil.getCurrentUser() != null) {
            currentUser = userService.findByEmail(SessionUtil.getCurrentUser().getEmail());
            model.addAttribute("userName", currentUser.getUserName());
        }

        if (currentUser.getDescription() == null) {
            model.addAttribute("description", "Please click the pencil icon to update something about you!\uD83E\uDD70");
        } else {
            model.addAttribute("description", currentUser.getDescription());
        }

        if (currentUser.getAddress() == null) {
            model.addAttribute("address", "Please click the pencil icon to update your address!\uD83E\uDD70");
        } else {
            model.addAttribute("address", currentUser.getAddress());
        }

        return "viewProfile"; //return viewProfile.jsp
    }

    @RequestMapping(value = "/viewProfile", method = RequestMethod.POST)
    public String viewProfile(@RequestParam(required=false , value = "facebook") String facebook,
                             Model model){

        if (SessionUtil.getCurrentUser() == null) {
            return "redirect:/login";
        }

        User currentUser = userService.findByEmail(SessionUtil.getCurrentUser().getEmail());
        model.addAttribute("userName", currentUser.getUserName());

        if (currentUser.getDescription() == null) {
            model.addAttribute("description", "Please click the pencil icon to update something about you!\uD83E\uDD70");
        } else {
            model.addAttribute("description", currentUser.getDescription());
        }

        if (currentUser.getAddress() == null) {
            model.addAttribute("address", "Please click the pencil icon to update your address!\uD83E\uDD70");
        } else {
            model.addAttribute("address", currentUser.getAddress());
        }

        if (facebook != null && facebook.equals("facebook")) {
            if (currentUser.getFbURL() != null) {
                String fbURL = currentUser.getFbURL();
                return "redirect:" + fbURL;
            } else {
                model.addAttribute("urlWarning", "There is no related Facebook link \uD83D\uDE25. " +
                        "Please click the pencil icon to update your FaceBook link!");
                return "viewProfile";
            }
        }

        model.addAttribute("urlWarning", "Failed");
        return "viewProfile";
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editProfile(Model model) {

        if (SessionUtil.getCurrentUser() == null) {
            return "redirect:/login";
        }
        User currentUser = userService.findByEmail(SessionUtil.getCurrentUser().getEmail());
        model.addAttribute("userName", currentUser.getUserName());

        if (currentUser.getDescription() == null) {
            model.addAttribute("description", "Input anything about you here!\uD83E\uDD70");
        } else {
            model.addAttribute("description", currentUser.getDescription());
        }
        return "editProfile";
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public String editProfile(@RequestParam("userName") String userName,
                              @RequestParam("description") String description,
                              @RequestParam("address") String address,
                              @RequestParam("fbURL") String fbURL,
                              Model model, HttpServletRequest request) throws InterruptedException, ApiException, IOException {
        if (SessionUtil.getCurrentUser() == null) {
            return "redirect:/login";
        }
        User currentUser = userService.findByEmail(SessionUtil.getCurrentUser().getEmail());
        model.addAttribute("userName", currentUser.getUserName());

        // When the user didn't input anything but pressed the submit button
        if (userName.length() == 0 && description.length() == 0
        && fbURL.length() == 0 && address.length() == 0) {
            model.addAttribute("warning", "Sorry! You cannot submit an empty form!\uD83D\uDE05");
            return "editProfile";
        }

        // Limit the length of username input
        if (userName.length() > 0) {
            if (userName.length() > 50) {
                model.addAttribute("userNameWarning", "Failed to change your username, it is too long\uD83E\uDD70");
                return "editProfile";
            } else {
                currentUser.setUserName(userName);
            }
        }

        // Limit the length of this description
        if (description.length() > 0) {
            if (description.length() > 500) {
                model.addAttribute("desWarning", "Failed to edit your description, it is too long\uD83E\uDD70");
                return "editProfile";
            } else {
                currentUser.setDescription(description);
            }
        }

        if (address.length() > 0) {

            if (address.length() >= 100 ) {
                model.addAttribute("addressWarning", "Please input the correct address\uD83E\uDD70");
                return "editProfile";
            }

            if(!MapAPI.validate(address)) {
                model.addAttribute("addressWarning", "Sorry! This address cannot be found on Google Maps\uD83E\uDD70");
                return "editProfile";
            } else {
                currentUser.setAddress(address);

                SessionUtil.getCurrentUser().setAddress(address);

            }
        }

        if (fbURL.length() > 0) {
            if (!fbURL.startsWith("https://www.facebook.com") || fbURL.length() >= 200) {
                model.addAttribute("fbWarning", "Please input the correct FaceBook link\uD83E\uDD70");
                return "editProfile";
            } else {
                currentUser.setFbURL(fbURL);
            }
        }

        userService.update(currentUser);
        return "redirect:/viewProfile";
    }

}


