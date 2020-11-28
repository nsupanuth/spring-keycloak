package com.example.springkeycloak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private final HttpServletRequest request;

    @Autowired
    public TaskController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/tasks")
    public String getTasks(Model model) {
        List tasks = Arrays.asList("task1", "task2", "task3");
        model.addAttribute("tasks", tasks);
//        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
        return "tasks";
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

}
