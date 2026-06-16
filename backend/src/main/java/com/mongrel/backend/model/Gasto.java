package com.mongrel.backend.model;

import jakarta.persistence.*;

@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double valor;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Construtor vazio obrigatório pro JPA //

    public Gasto () {}

    // getters e setters //

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}
}