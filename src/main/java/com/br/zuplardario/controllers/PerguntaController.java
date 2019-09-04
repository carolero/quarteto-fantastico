package com.br.zuplardario.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.zuplardario.models.Pergunta;
import com.br.zuplardario.services.PerguntaService;

@RestController
@RequestMapping("api/perguntas")
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	// CRUD
	// C
	@PostMapping
	public ResponseEntity<?> criaPergunta(@Valid @RequestBody Pergunta pergunta) {
		try {
			perguntaService.cadastrarPergunta(pergunta);
			return ResponseEntity.status(HttpStatus.CREATED).body(pergunta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	// R
	@GetMapping("/")
	public ResponseEntity<?> exibirTodasPerguntas() {
		try {
			return ResponseEntity.ok().body(perguntaService.pegarTodasPerguntas());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> pegarPergunta(@PathVariable int id) {
		try {
			Pergunta pergunta = perguntaService.pegarPerguntaPeloId(id);
			return ResponseEntity.ok(pergunta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
