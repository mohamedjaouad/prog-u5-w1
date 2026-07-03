package mohamedjaouad.prog_u5_w1.services;

import mohamedjaouad.prog_u5_w1.entities.Edificio;
import mohamedjaouad.prog_u5_w1.exceptions.duplications.EdificioDuplicatoException;
import mohamedjaouad.prog_u5_w1.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    private final EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public void save(Edificio edificio) {
        if (edificioRepository.existsByNomeAndIndirizzo(edificio.getNome(), edificio.getIndirizzo())) {
            throw new EdificioDuplicatoException(edificio.getNome(), edificio.getIndirizzo());
        }
        edificioRepository.save(edificio);
    }

}
