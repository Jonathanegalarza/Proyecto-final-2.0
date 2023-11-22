
 package com.example.proyecto.entidades;



import com.example.proyecto.enumeraciones.Rol;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Data;


@Data
@Entity
@PrimaryKeyJoinColumn(name = "persona_dni")
public class Cliente extends Persona{
    @ElementCollection(targetClass = Rol.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cliente_roles", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "rol")
    private Set<Rol> roles;
    
    /*
    @ManyToMany(cascade = CascadeType.ALL)': Esta anotación se utiliza para declarar una relación de varios a varios.
    Significa que un 'Cliente' puede estar asociado con múltiples entidades 'Proveedor', y viceversa. 
    La 'cascada = CascadeType.ALL' significa que cualquier operación (por ejemplo, persistir, fusionar, eliminar) 
    realizada en la entidad 'Cliente' debe conectarse en cascada a las entidades 'Proveedor' asociadas, 
    y viceversa.

- '@JoinTable': esta anotación se utiliza para especificar los detalles de la tabla de unión que se utilizará
    para administrar la relación de varios a varios. En una relación de varios a varios, se necesita una tabla 
    intermedia (tabla de combinación) para almacenar las asociaciones entre las dos entidades.

- 'name = "cliente_proveedor"': Especifica el nombre de la tabla de unión en la base de datos, que se utilizará 
    para almacenar las asociaciones entre 'Cliente' y 'Proveedor'.

- 'joinColumns = @JoinColumn(name = "cliente_id")': especifica la columna de la tabla de unión que hace
    referencia a la entidad 'Cliente'. Establece una relación de clave externa de la tabla de unión a 
    la tabla 'Cliente'.

- 'inverseJoinColumns = @JoinColumn(name = "proveedor_id")': especifica la columna de la tabla de combinación
    que hace referencia a la entidad 'Proveedor'. Establece una relación de clave externa desde la tabla de
    unión hasta la tabla 'Proveedor'.
    */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "cliente_proveedor",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
   private List<Proveedor> proveedor;
    
   @OneToMany
     private List<Trabajo> trabajo;    
    
}
