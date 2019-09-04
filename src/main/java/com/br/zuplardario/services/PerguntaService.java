package com.br.zuplardario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.zuplardario.models.Pergunta;
import com.br.zuplardario.repositories.PerguntasRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntasRepository perguntasRepository;

	// C (Create)
	public String cadastrarPergunta(Pergunta pergunta) {
		perguntasRepository.save(pergunta);
		return "Pergunta cadastrada";
	}

	// R (Visualizar)
	public Iterable<Pergunta> pegarTodasPerguntas() {
		return perguntasRepository.findAll();
	}

	public Pergunta pegarPerguntaPeloId(int id) {
		return perguntasRepository.findById(id).get();
	}

	public long quantidadeDePerguntas() {
		return perguntasRepository.count();
	}
}
