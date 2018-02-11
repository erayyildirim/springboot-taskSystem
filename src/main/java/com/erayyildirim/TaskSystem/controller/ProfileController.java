package com.erayyildirim.TaskSystem.controller;

import com.erayyildirim.TaskSystem.model.Task;
import com.erayyildirim.TaskSystem.model.User;
import com.erayyildirim.TaskSystem.service.TaskService;
import com.erayyildirim.TaskSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getShowProfilePage(Model model, Principal principal){

        String email = principal.getName();

        User user = userService.findOneUser(email);
        model.addAttribute("tasks",taskService.findUserTask(user));
        return "views/profile";
    }

}
