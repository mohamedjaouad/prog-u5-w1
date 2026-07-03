package mohamedjaouad.prog_u5_w1.repositories;

import mohamedjaouad.prog_u5_w1.Enum.TipoPostazione;
import mohamedjaouad.prog_u5_w1.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND LOWER(p.edificio.citta) = LOWER(:citta)")
    List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta);

    boolean existsByCodice(String codice);

}
