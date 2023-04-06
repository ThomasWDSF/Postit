package com.postit.postit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.postit.postit.models.User;
import com.postit.postit.repositorio.UserRepo;
import org.springframework.ui.Model;

@Controller
public class RegisterController {
    
    @Autowired
    private UserRepo repo;

    @GetMapping("/register")
    public String register(){

        return "register/index";
    }

    @PostMapping("/criar")
    public String criar(User user, Model model){

        User user2 = repo.Validar(user.getEmail());

        model.addAttribute("existe", "Esse email já existe");
        
        if(user2 != null){
            return "register/index";
        } else {
            
            repo.save(user);
            return "postit/novo";
        }

    }

}
