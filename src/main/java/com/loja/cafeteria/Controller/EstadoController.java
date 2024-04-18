package com.loja.cafeteria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loja.cafeteria.Models.Estado;
import com.loja.cafeteria.Repositorio.EstadoRepositorio;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@GetMapping("/administrativo/estados/cadastro")
	public ModelAndView cadastrar(Estado estado) {
		ModelAndView modelView = new ModelAndView("/administrativo/estados/cadastro");
		modelView.addObject("estado", estado);
		return modelView;
	}
	
	@PostMapping("/salvarEstado")
	public ModelAndView salvar(Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			return cadastrar(estado);
		}
		estadoRepositorio.saveAndFlush(estado);
		
		return cadastrar(new Estado());
	}
}
