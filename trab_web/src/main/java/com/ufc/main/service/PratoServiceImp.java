package com.ufc.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ufc.main.model.Prato;
import com.ufc.main.repository.PratoRepository;
import com.ufc.main.util.Utils;

@Service
public class PratoServiceImp implements PratoService {

	@Autowired
	private PratoRepository pratoRepository;

	@Override
	public List<Prato> listarPratos() {
		return pratoRepository.findAll();
	}

	@Override
	public void salvarPrato(Prato prato, MultipartFile imagem) {
		String local = "images/" + prato.getPnome() + ".png";
		Utils.salvarImagem(local, imagem);
		pratoRepository.save(prato);
	}

	@Override
	public Prato buscarPrato(Integer id) {
		return pratoRepository.getOne(id);
	}

	@Override
	public void deletarPrato(Integer id) {
		pratoRepository.deleteById(id);
	}

}
