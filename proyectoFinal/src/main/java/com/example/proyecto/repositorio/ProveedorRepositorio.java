/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.proyecto.repositorio;


import com.example.proyecto.entidades.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
    /*
@Query("SELECT p FROM ProveedorServ p WHERE"
            + " CONCAT(p.id,p.nombre,p.precio)"
            + " LIKE %?1%")
    public List<Proveedor> findAlllList(String palabraClave);
*/
}
