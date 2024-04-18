package com.loja.cafeteria.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.cafeteria.Models.Estado;

public interface EstadoRepositorio extends JpaRepository<Estado, Long> {

}
