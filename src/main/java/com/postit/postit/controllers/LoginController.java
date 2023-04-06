package com.postit.postit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.postit.postit.models.User;
import com.postit.postit.repositorio.UserRepo;

@Controller
public class LoginController {
    
    @Autowired
    private UserRepo repo;

    @GetMapping("/login")
    public String login(){

        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, User userParam){

        User user = repo.Login(userParam.getEmail(),userParam.getSenha());

        if(user != null){
            return "redirect:/postit/novo";
        }

        model.addAttribute("erro", "Email ou senha inválidos");

        return "login/index";
    }

}
