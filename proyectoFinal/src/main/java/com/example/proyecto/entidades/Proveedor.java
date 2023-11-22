
package com.example.proyecto.entidades;



import com.example.proyecto.enumeraciones.EstadoTrabajo;
import com.example.proyecto.enumeraciones.Rol;
import java.util.Date;
import java.util.List;
//import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "persona_dni")
public class Proveedor extends Persona{
    
private String matricula;//
private String descripcion;//
private int puntuacionPromedio;//esto es para las estrellita
@ManyToMany
private List<Rubro> rubro;
//private EstadoTrabajo estadoTrabajo;//visualiza en el perfil del proveedor 
private boolean estadoActual;//Depende del estado actual
private double precioHora;
private Date fechaAlta;
private int contdTrabajoRealizado;//esto permite scar un promedio de los trabajos realizados
@ElementCollection(targetClass = Rol.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cliente_roles", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "rol")
    private List<Rol> roles;
 
 @OneToOne
 private Imagen imagen;
 
}
