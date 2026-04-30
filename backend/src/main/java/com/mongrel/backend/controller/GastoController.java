package com.mongrel.backend.controller;

import com.mongrel.backend.model.Gasto; // importando entidade //
import com.mongrel.backend.service.GastoService; //importando service para acesso ao banco//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; //para trabalhar com listas//

@RestController //responde a requisições HTTP (tudo aqui pode ser acessado via URL)//
@RequestMapping("/gastos") //define rota base: http: barra barra localhost:8080 barra gastos//
@CrossOrigin //libera acesso do frontend, requisição permitida//
public class GastoController {
    private final GastoService gastoService;
    //injeção do service, cria a dependencia gastoService automatico e injeta aqui//
    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }
    @PostMapping
    public Gasto criar(@RequestBody Gasto gasto) {
        return gastoService.criar(gasto);
    }
    //@PostMapping = metodo POST//
    //@RequestBody = pega o JSON da requisição e transforma em objeto java//
    //return gastoService = salva o objeto gasto cadastrado chamando o service//

    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listar();
    }
    //@GetMapping = metodo GET//
    //return gastoService.listar() = retorna os dados cadastrados//
}