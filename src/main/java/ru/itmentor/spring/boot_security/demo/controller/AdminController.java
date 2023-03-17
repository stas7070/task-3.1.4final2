package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    /*@GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "create";
    }
    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "update";
    }*/





    @GetMapping
    public String getAllUsers(Model model, Principal principal){
        model.addAttribute("admin", userService.getUserByEmail(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("user", new User());
        return "admin";
    }
    @PostMapping("/create")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam("listRoles") List<String> values){
        user.listRoles(roleService.listRole(values));
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id,
                       @ModelAttribute("user") User user,
                       @RequestParam("listRoles") List<String> values){
        user.setRoles(roleService.listRole(values));
        userService.updateUser(id, user);
        System.out.println(user.getName());
        return "redirect:/admin";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}