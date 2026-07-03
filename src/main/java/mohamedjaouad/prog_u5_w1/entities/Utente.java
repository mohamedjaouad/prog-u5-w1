package mohamedjaouad.prog_u5_w1.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    public Utente(String username, String surname, String email) {
        this.username = username;
        this.surname = surname;
        this.email = email;
    }
}