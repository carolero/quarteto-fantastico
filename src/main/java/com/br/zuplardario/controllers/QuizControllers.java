package com.br.zuplardario.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zuplardario.models.Pergunta;
import com.br.zuplardario.services.PerguntaService;

@Controller
public class QuizControllers {

	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping("/")
	public ModelAndView mostrarPaginaInicial() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	@GetMapping()
	public ModelAndView gerenciadorDePerguntas() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView GerenciadorDePerguntas(@Valid Pergunta pergunta, BindingResult bindingResults) {
		ModelAndView modelAndView = new ModelAndView(); 
		List<String> mensagens = new ArrayList<String>();
		if(bindingResults.hasErrors()) {
			for (ObjectError objectError : bindingResults.getAllErrors()) {
				mensagens.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
		}
		modelAndView.addObject("mensagens", perguntaService.cadastrarPergunta(pergunta));
		return modelAndView;
	}
	
	@GetMapping("")
	public ModelAndView paginaPerguntas() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
}
