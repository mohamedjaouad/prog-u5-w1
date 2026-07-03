package mohamedjaouad.prog_u5_w1.repositories;

import mohamedjaouad.prog_u5_w1.entities.Postazione;
import mohamedjaouad.prog_u5_w1.entities.Prenotazione;
import mohamedjaouad.prog_u5_w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);

    boolean existsByUtenteAndPostazioneAndDataPrenotazione(Utente utente, Postazione postazione, LocalDate data);

}
