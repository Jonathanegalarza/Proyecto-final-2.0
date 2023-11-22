package com.example.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.entidades.Imagen;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen, String>{

}
