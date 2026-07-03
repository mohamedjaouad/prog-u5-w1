package mohamedjaouad.prog_u5_w1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPrenotazione;

    @ManyToOne
    @ToString.Exclude
    private Utente utente;

    @ManyToOne
    @ToString.Exclude
    private Postazione postazione;
}
