package com.erayyildirim.TaskSystem.controller;

import com.erayyildirim.TaskSystem.model.Task;
import com.erayyildirim.TaskSystem.service.TaskService;
import com.erayyildirim.TaskSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
   // @GetMapping("/addTask/{email}")
    public String getTaskForm(Model model, String email, HttpSession session){

        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskForm";
    }

    @PostMapping("/addTask")
    public String postTaskForm(@Valid Task task, BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){
            return "views/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task,userService.findOneUser(email));

        return "redirect:/users";
    }
}
