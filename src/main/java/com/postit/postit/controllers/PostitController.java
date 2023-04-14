package com.postit.postit.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.postit.postit.models.Postit;
import com.postit.postit.repositorio.PostitRepo;

@Controller
public class PostitController {
    
    @Autowired
    private PostitRepo prepo;

    //Buscar uma lista de todos postits do banco
    @GetMapping("/postit/postites")
    public String index(Model model){
        List<Postit> postits = (List<Postit>)prepo.findAll();
        model.addAttribute("postits", postits);
        return "postit/postites";
    }


    @GetMapping("/postit")
    public String index(){

        return "postit/index";
    }

    @GetMapping("/postit/novo")
    public String novo(){

        return "postit/novo";
    }

    //Postar no banco o postit criado no template
    @PostMapping("/criarpostit")
    public String criarpostit(Postit postit){
        prepo.save(postit);
        return"redirect:/postit/postites";
    }

    @GetMapping("postit/{id}")
        public String busca(@PathVariable int id, Model model){
            Optional<Postit> postits = prepo.findById(id);
            try{ model.addAttribute("postit", postits.get());}
                catch(Exception erro) {return "redirect:/postit";}
                return "postit/editar";
        }

    @PostMapping("postit/{id}/atualizar")
        public String atualizar(@PathVariable int id, Postit postit){
            if(!prepo.existsById(id)){
                return "redirect:/postit";
            }
            prepo.save(postit);
            return "redirect:/postit/postites";
        }

    @GetMapping("postit/{id}/excluir")
    public String excluir(@PathVariable int id){
        prepo.deleteById(id);
        return "redirect:/postit/postites";
    }

    }