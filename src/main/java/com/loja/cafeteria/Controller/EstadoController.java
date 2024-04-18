package com.loja.cafeteria.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/administrativo/estados/lista")
	public ModelAndView listar() {
		ModelAndView modelView = new ModelAndView("/administrativo/estados/lista");
		modelView.addObject("ListaEstados", estadoRepositorio.findAll());
		return modelView;
	}

	@GetMapping("/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepositorio.findById(id);
		return cadastrar(estado.get());
	}
	
	@GetMapping("/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		Optional<Estado> estado = estadoRepositorio.findById(id);
		estadoRepositorio.delete(estado.get());
		return listar();
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
