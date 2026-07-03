package mohamedjaouad.prog_u5_w1.repositories;

import mohamedjaouad.prog_u5_w1.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    boolean existsByNomeAndIndirizzo(String nome, String indirizzo);

}