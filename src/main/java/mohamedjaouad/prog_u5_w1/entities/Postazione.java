package mohamedjaouad.prog_u5_w1.entities;

import jakarta.persistence.*;
import lombok.*;
import mohamedjaouad.prog_u5_w1.Enum.TipoPostazione;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String codice;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int maxOccupanti;

    @ManyToOne
    @ToString.Exclude
    private Edificio edificio;
}
