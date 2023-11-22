
package com.example.proyecto.repositorios;

import com.example.proyecto.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String> {

    @Query("SELECT u FROM Usuario u WHERE u.dni = :dni")
    public Proveedor buscarPorDni(@Param("dni") String dni);
            

}