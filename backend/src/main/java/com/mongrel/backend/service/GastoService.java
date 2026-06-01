package com.mongrel.backend.service;

import com.mongrel.backend.dto.GastoRequestDTO;
import org.springframework.stereotype.Service;
import com.mongrel.backend.model.Gasto;
import com.mongrel.backend.repository.GastoRepository;
import java.util.List;

@Service
public class GastoService {
    private final GastoRepository gastoRepository;
    //declara que o service depende do repository//
    //private: só essa classe acessa. final: não muda apos inicializado//

    public GastoService(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;

    //injeção de dependencia (injetar a dependencia gastoRepository dentro do service sem precisar criar ela)//
    }

    public Gasto criar(GastoRequestDTO dto) {

        Gasto gasto = new Gasto();

        gasto.setDescricao(dto.descricao());
        gasto.setValor(dto.valor());

        if (gasto.getValor() <= 0) {
            throw new RuntimeException("Valor inválido");
        }
        return gastoRepository.save(gasto);
        //se passou na validação salva os dados no banco//
    }
    public List<Gasto> listar() {
        return gastoRepository.findAll();
        //busca todos os gastos, chama o repository e retorna uma lista//
    }
}