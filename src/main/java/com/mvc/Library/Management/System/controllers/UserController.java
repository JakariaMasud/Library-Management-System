package com.mvc.Library.Management.System.controllers;
import com.mvc.Library.Management.System.entities.User;
import com.mvc.Library.Management.System.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/auth/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping(value = "/auth/register")
    public String register(@ModelAttribute User user, Model model, BindingResult result){
        if(result.hasErrors()){
           return "register";
        }
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.register(user);
        return "login";
    }
    @RequestMapping(value = "/auth/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "login";
    }

    @RequestMapping(value = "/auth/index")
    public String authIndex(){
        return "auth-index";
    }


}
