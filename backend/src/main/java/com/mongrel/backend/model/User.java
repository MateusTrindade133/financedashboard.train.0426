package com.mongrel.backend.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)

    private String email;

    @Column(nullable = false)

    private String senha;

    @OneToMany(mappedBy = "user")
    private List<Gasto> gastos = new ArrayList<>();

    public User() {

    }

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    } //diz que os atributos mencionados apos o this. terão o valor recebido pelo usuario//

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha (String senha){
        this.senha = senha;
    }
}