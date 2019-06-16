package com.ufc.main.model;

import org.springframework.stereotype.Controller;

@Controller
public class Prato {

	@Id
	@GeneratedV
	private int cod;

	private String nome;

	private String desc;

	private float preco;
}
