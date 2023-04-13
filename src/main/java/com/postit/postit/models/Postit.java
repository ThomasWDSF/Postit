package com.postit.postit.models;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Postits")
public class Postit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "Titulo")
    @Size(min=1,max=15)
    private String titulo;

    @Column(name = "Conteudo")
    @Size(min=0,max=255)
    private String conteudo;

    @DateTimeFormat
    @Column(name = "Data Prevista")
    @CreatedDate
    private LocalDate dataPrevista;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public LocalDate dataPrevista(){
        return this.dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista){
        this.dataPrevista = dataPrevista;
    }

}
