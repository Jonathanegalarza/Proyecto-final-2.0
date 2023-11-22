
package com.example.proyecto.entidades;

//import com.example.proyecto.enumeraciones.TipoRubro;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Rubro {
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idRubro;
    private String descripcion;//Detalle de los trabajo
    private String nombreRubro;
   // private TipoRubro tipoRubro;

    public void setNombre(String nombreRubro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
