package com.ufc.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.main.model.Prato;
import com.ufc.main.model.User;
import com.ufc.main.service.PratoService;
import com.ufc.main.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PratoService pratoService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("registro");
		User user = new User();
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		List<Prato> pratos = pratoService.listarPratos();
		mv.addObject("pratos", pratos);
		return mv;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView mv = new ModelAndView("registro");
		// Check for the validations
		if (bindingResult.hasErrors()) {
			mv.addObject("msg", "Há erros no fomulário!");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (userService.userJaExiste(user)) {
			mv.addObject("msg", "Usuario ja existe!");
		} // we will save the user if, no binding errors
		else {
			userService.saveUser(user);
			mv.addObject("msg", "Usuario Cadastrado com sucesso!");
		}
		mv.addObject("user", new User());
		return mv;
	}
}
