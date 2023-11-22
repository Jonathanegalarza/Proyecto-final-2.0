
package com.example.proyecto.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY) especifica que el valor de id se generará
    automáticamente por la base de datos utilizando una estrategia de identidad (autoincremental).
    */
  @Id
/*
  @Column(unique = true) en la columna dni indica que esta columna debe contener valores únicos,
  actuando como una clave única para evitar duplicados.
  */
 
  private String dni;//
  private String nombre;
  private String apellido;
  private String domicilio;
  private String telefono;
  private String email;
  private String password;
  
  @Temporal(TemporalType.DATE)
  private Date fechaAlta; 
  private boolean alta;
  @OneToOne
  private Imagen imagen;

    
    
   
  
   
}
