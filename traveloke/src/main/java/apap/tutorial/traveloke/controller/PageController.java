package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.repository.RoleDb;

@Controller
public class PageController {

    @Autowired
    RoleDb roleDb;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String roleCurrentUser = authentication.getAuthorities().toString();
        model.addAttribute("roleCurrentUser", roleCurrentUser);
        model.addAttribute("listRole", roleDb.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/updatePassword")
    public String changePassword(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("listRole", roleDb.findAll());
        return "change-password";
    }
}
