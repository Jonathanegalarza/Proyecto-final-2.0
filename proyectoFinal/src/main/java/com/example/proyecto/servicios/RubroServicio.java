/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.proyecto.servicios;

import com.example.proyecto.entidades.Rubro;
import com.example.proyecto.repositorio.RubroRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.stereotype.Service;

/**
 *
 * @author aprig
 */
@Service
public class RubroServicio {
    
    RubroRepositorio rubroRepositorio;
    
    @Transactional
    public void CrearRubro(String IdRubro, String descripcion, String nombreRubro){
        //ValidarDatos(descripcion, nombreRubro);
        Rubro rubro = new Rubro();
        
        rubro.setNombre(nombreRubro);
        rubro.setDescripcion(descripcion);
        
        rubroRepositorio.save(descripcion,nombreRubro);
        
    }
    @Transactional
     public List<Rubro> ListaRubros() {

        List<Rubro> rubros = new ArrayList();

        rubros = rubroRepositorio.findAll();

        return rubros;
    }
     
     @Transactional
     public void ModificarRubro(String IdRubro,String descripcion, String nombreRubro) {
        //ValidarDatos(nombreRubro,idRubro);

        Optional<Rubro> respuesta = rubroRepositorio.findById(IdRubro);


        if (respuesta.isPresent()) {

            Rubro rubro = respuesta.get();

            rubro.setNombre(nombreRubro);
            rubro.setDescripcion(descripcion);

            rubroRepositorio.save(rubro);

        }
    
     }
   
         
   
    

}