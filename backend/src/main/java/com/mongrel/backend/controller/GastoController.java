package com.mongrel.backend.controller;

import com.mongrel.backend.model.Gasto; // importando entidade //
import com.mongrel.backend.repository.GastoRepository; //importando repositorio de acesso ao banco//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; //para trabalhar com listas//

@RestController //responde a requisições HTTP (tudo aqui pode ser acessado via URL)//
@RequestMapping("/gastos") //define rota base: http: barra barra localhost:8080 barra gastos//
@CrossOrigin //libera acesso do frontend, requisição permitida//
public class GastoController {
    @Autowired
    private GastoRepository repo;
    //injeção do repositorio, cria ele automatico e injeta aqui//

    @PostMapping
    public Gasto criar(@RequestBody Gasto gasto) {
        return repo.save(gasto);
    }
    //@PostMapping = metodo POST//
    //@RequestBody = pega o JSON da requisição e transforma em objeto java//
    //return repo.save = retorna objeto salvo//

    @GetMapping
    public List<Gasto> listar() {
        return repo.findAll();
    }
    //@GetMapping = metodo GET//
    //return repo.findAll = retorna os dados cadastrados//
}