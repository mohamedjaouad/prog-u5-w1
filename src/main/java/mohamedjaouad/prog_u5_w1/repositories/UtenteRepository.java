package mohamedjaouad.prog_u5_w1.repositories;


import mohamedjaouad.prog_u5_w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    boolean existsByUsername(String username);

}
