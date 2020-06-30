package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    public String printWelcome(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listUser", users);
        return "users";
    }
}
