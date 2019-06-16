package com.ufc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.main.model.Prato;
import com.ufc.main.service.PratoService;

@Controller
@RequestMapping("/admin")
public class PratoController {

	@Autowired
	private PratoService service;

	@RequestMapping("/listar")
	public ModelAndView listarPratos() {
		List<Prato> pratos = service.listar();
		ModelAndView mv = new ModelAndView("ListaPratos");
		mv.addObject("listaPratos", pratos);
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView addPrato() {
		ModelAndView mv = new ModelAndView("AddPrato");
		mv.addObject("prato", new Prato());
		return mv;
	}

	@RequestMapping("/salvar")
	public ModelAndView salvarPrato(@Validated Prato prato) {
		service.salvar(prato);
		ModelAndView mv = new ModelAndView("redirect:/admin/listar");
		return mv;
	}

	@RequestMapping("/editar/{cod}")
	public ModelAndView editarPrato(@PathVariable Integer cod) {
		Prato prato = service.buscar(cod);
		ModelAndView mv = new ModelAndView("EditarPrato");
		mv.addObject("prato", prato);
		return mv;
	}

	@RequestMapping("/deletar/{cod}")
	public ModelAndView deletarPrato(@PathVariable Integer cod) {
		service.deletar(cod);
		ModelAndView mv = new ModelAndView("redirect:/admin/listar");
		return mv;
	}
}
