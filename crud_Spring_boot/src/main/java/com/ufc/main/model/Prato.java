package com.ufc.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pratos")
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;

}
