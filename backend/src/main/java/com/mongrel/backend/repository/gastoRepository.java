package com.mongrel.backend.repository;
// a partir do com/mongrel/... pois src/main/java é a raiz do codigo fonte.//
//tudo que esta dentro de src/main/java/ fica "invisivel pro package"//
import com.mongrel.backend.model.Gasto;
// conecta o repositorio com a entidade da pasta model //
import org.springframework.data.jpa.repository.JpaRepository;

public interface gastoRepository extends JpaRepository<Gasto, Long> {

} // sem escrever nenhum SQL temos: "quero um repositorio que gerencia Gasto usando ID do tipo Long" //
//Long = numero inteiro grande como 999999999, é utilizado para Ids por motivos obvios//
// acabamos de criar um sistema que sabe: salvar no db, buscar tudo, buscar id e deletar//
