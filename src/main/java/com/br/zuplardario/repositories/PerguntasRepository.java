package com.br.zuplardario.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zuplardario.models.Pergunta;

@Repository
public interface PerguntasRepository extends CrudRepository<Pergunta, Integer> {

}
