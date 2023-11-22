
package com.example.proyecto.servicios;

import com.example.proyecto.entidades.Imagen;
import com.example.proyecto.entidades.Proveedor;
import com.example.proyecto.enumeraciones.Rol;
import com.example.proyecto.exception.MiException;
import com.example.proyecto.repositorios.ProveedorRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    
    @Autowired
    private ImagenServicio imagenServicio;

    @Transactional
    public void crearProveedor(MultipartFile archivo, String nombre, String apellido, String dni, String telefono, String email, String password,
                               String password2, String matricula, String descripcion,
                               double precioHora, Date fechaAlta, List<Rol> roles) throws MiException {
        validar(nombre, apellido, dni, telefono, email, password, password2, precioHora, fechaAlta);

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setDni(dni);
        proveedor.setTelefono(telefono);
        proveedor.setEmail(email);
        proveedor.setPassword(password);
        proveedor.setDescripcion(descripcion); //Descripcion de cada proveedor Ej: horarios, presentación breve, etc.
        proveedor.setPrecioHora(precioHora); //Es el valor de los honorarios por hora. 
        proveedor.setFechaAlta(new Date()); // Asigna la fecha actual
        //List<Rol> roles = new ArrayList<>();
        roles.add(Rol.PROVEEDOR);        
        proveedor.setRoles(roles);   
        
        Imagen imagen = imagenServicio.guardar(archivo);

        proveedor.setImagen(imagen);
        
        proveedorRepositorio.save(proveedor);
    }

   

    @Transactional   
    private void validar(String nombre, String apellido, String dni, String telefono, String email, String password, String password2, double precioHora, Date fechaAlta) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede ser nulo o estar vacío");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new MiException("El apellido no puede ser nulo o estar vacío");
        }

        if (dni == null || dni.isEmpty()) {
            throw new MiException("El DNI no puede ser nulo o estar vacío");
        }

        if (telefono == null || telefono.isEmpty()) {
            throw new MiException("El teléfono no puede ser nulo o estar vacío");
        }

        if (email == null || email.isEmpty()) {
            throw new MiException("El email no puede ser nulo o estar vacío");
        }

        if (password == null || password.isEmpty() || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

        if (precioHora == 0.0) {
            throw new MiException("El campo honorarios/hora no puede estar vacío o ser cero");
        }

        Date fechaActual = new Date(); 
        if (fechaAlta == null || fechaAlta.before(fechaActual)) {
            throw new MiException("La fecha de alta no puede ser nula o ser una fecha futura.");
        }
    }
    
    
    
}
