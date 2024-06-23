package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "ProgramaTv")
public class ProgramaTv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgramaTv;

    @Column(name = "Titulo", nullable = false, length = 250)
    private String titulo;

    @Column(name = "Resumen", nullable = false, length = 250)
    private String resumen;

    @Column(name = "FechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "IdPersonaje", nullable = false)
    private Personaje personaje;
}
