package com.postit.postit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.postit.postit.models.Postit;
import com.postit.postit.repositorio.PostitRepo;

@Controller
public class PostitController {
    
    @Autowired
    private PostitRepo prepo;

    @GetMapping("/postit")
    public String index(){

        return "postit/index";
    }

    @GetMapping("/postit/novo")
    public String novo(){

        return "postit/novo";
    }

    @PostMapping("/criarpostit")
    public String criarpostit(Postit postit){
        prepo.save(postit);
        return"login/index";
    }

}
