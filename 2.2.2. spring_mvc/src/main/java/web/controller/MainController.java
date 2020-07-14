package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/admin/users")
    public String tableUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("newUser", new User());
        model.addAttribute("listUser", users);
        return "users";
    }

    @PostMapping(value = "/admin/edit")
    public String editUsers(@Valid @ModelAttribute("userData") User userData, BindingResult result) {
        User user = userService.getUserById(userData.getId());
        if(result.hasErrors()){
            return "editForm";
        }
        userData.setRoles(user.getRoles());
        userService.updateUser(userData);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/admin/edit")
    public String editUsers(@RequestParam("id") Long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("userData", user);
        return "editForm";
    }

    @GetMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<User> users = userService.getAllUsers();
            model.addAttribute("listUser", users);
            return "users";
        }
        userService.addUser(newUser);
        return "redirect:/admin/users";
    }
}
