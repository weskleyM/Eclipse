package com.ufc.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.main.model.Prato;
import com.ufc.main.repository.PratoRepository;

@Service
public class PratoService {

	@Autowired
	public PratoRepository repo;

	public List<Prato> listar() {
		return repo.findAll();
	}

	public void salvar(Prato prato) {
		repo.save(prato);
	}

	public Prato buscar(Integer cod) {
		return repo.findById(cod).get();
	}

	public void deletar(Integer cod) {
		repo.deleteById(cod);
	}
}
