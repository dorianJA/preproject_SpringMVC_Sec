package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    public String tableUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("listUser", users);
        return "users";
    }

    @PostMapping(value = "/edit")
    public String editUsers(@ModelAttribute("userData") User userData){
        userService.updateUser(userData);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit")
    public String editUsers(@RequestParam("id")int id, ModelMap model){
        User user = userService.getUserById(id);
        model.addAttribute("userData",user);
        return "editForm";
    }
    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id")int id){
        userService.removeUser(id);
        return "redirect:/users";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("newUser")  User newUser){
        userService.addUser(newUser);
        return "redirect:/users";
    }
}
