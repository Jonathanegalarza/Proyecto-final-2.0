
package com.example.proyecto.servicios;

import com.example.proyecto.entidades.Cliente;
import com.example.proyecto.exception.MiException;
import com.example.proyecto.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServicio {
    
    @Autowired
    ClienteRepositorio clienteRepositorio;
    
    @Transactional
    public void crearCliente(String nombre,String apellido,String dni,String telefono, String email,String password ) throws MiException{
    
    validar(nombre, apellido, email, telefono, email, password, password);
    Cliente cliente=new Cliente();
    cliente.setNombre(nombre);
    cliente.setApellido(apellido);
    cliente.setDni(dni);
    cliente.setTelefono(telefono);
    cliente.setEmail(nombre);
    cliente.setPassword(nombre);
    clienteRepositorio.save(cliente);
    
    }
    
     @Transactional   
    private void validar(String nombre,String apellido ,String dni, String telefono,String email, String password, String password2) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if(apellido.isEmpty() || apellido==null){
        throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
        
        if(dni.isEmpty() || dni==null){
        throw new MiException("El dni no puede ser nulo o estar vacio");
        }
        
        if(telefono.isEmpty() || telefono==null){
        throw new MiException("El telefono no puede ser nulo o estar vacio");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }
    
}
