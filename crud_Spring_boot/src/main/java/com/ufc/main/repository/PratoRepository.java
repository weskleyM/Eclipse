package com.ufc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.main.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

}
