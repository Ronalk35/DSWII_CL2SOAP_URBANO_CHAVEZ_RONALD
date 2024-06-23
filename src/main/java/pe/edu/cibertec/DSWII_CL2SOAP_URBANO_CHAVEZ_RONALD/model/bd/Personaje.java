package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "Personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonaje;

    @Column(name = "NomPersonaje", nullable = false, length = 50)
    private String nomPersonaje;

    @Column(name = "ApePersonaje", nullable = false, length = 50)
    private String apePersonaje;

    @Column(name = "FechNacPersonaje", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechNacPersonaje;
}