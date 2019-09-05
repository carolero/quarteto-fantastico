package com.br.zuplardario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.zuplardario.models.Pergunta;
import com.br.zuplardario.repositories.PerguntasRepository;

@Service
public class PerguntaService {

	@Autowired
	private PerguntasRepository perguntasRepository;

	// (Create)
	public String cadastrarPergunta(Pergunta pergunta) {
		perguntasRepository.save(pergunta);
		return "Pergunta cadastrada";
	}

	// (Review)
	public Iterable<Pergunta> pegarTodasPerguntas() {
		return perguntasRepository.findAll();
	}

	public Pergunta pegarPerguntaPeloId(int id) {
		return perguntasRepository.findById(id).get();
	}

	public long quantidadeDePerguntas() {
		return perguntasRepository.count();
	}

	// (Update)
	public Pergunta atualizarPergunta(int id, Pergunta atualizar) {
		Pergunta teste = new Pergunta();
		teste = perguntasRepository.findById(id).get();

		if (teste != null) {
			atualizar.setId(id);
			return perguntasRepository.save(atualizar);

		}
		return null;

	}

	// (Delete)
	public void excluirPergunta(int id) {
		perguntasRepository.deleteById(id);
	}
}
