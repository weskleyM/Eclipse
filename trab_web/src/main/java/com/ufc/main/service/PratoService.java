package com.ufc.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ufc.main.model.Prato;

public interface PratoService {

	public List<Prato> listarPratos();

	public void salvarPrato(Prato prato, MultipartFile imagem);

	public Prato buscarPrato(Integer id);

	public void deletarPrato(Integer id);
}
