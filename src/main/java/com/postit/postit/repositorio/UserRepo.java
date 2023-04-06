package com.postit.postit.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.postit.postit.models.User;

public interface UserRepo extends CrudRepository<User,Integer>{
    
    @Query(value = "select * from usuario where email = :email and senha = :senha", nativeQuery = true)
    public User Login(String email, String senha);

    @Query(value = "select * from usuario where email = :email", nativeQuery = true)
    public User Validar(String email);

}
