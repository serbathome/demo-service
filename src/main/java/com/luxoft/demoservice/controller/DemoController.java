package com.luxoft.demoservice.controller;

import com.luxoft.demoservice.model.User;
import com.luxoft.demoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class DemoController {

    private final UserRepository userRepository;

    @Autowired
    public DemoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/create")
    public RedirectView createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        var newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return new RedirectView("/users");
    }

    @GetMapping("/users")
    public User[] getUsers() {
        return userRepository.findAll().toArray(new User[0]);
    }

    @GetMapping("/user")
    public ModelAndView render_form() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}