
package com.example.proyecto.repositorio;


import com.example.proyecto.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
    
}
