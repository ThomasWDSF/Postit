package com.postit.postit.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.postit.postit.models.Postit;

public interface PostitRepo extends CrudRepository<Postit, Integer>{

    
}
