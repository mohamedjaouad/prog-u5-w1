package mohamedjaouad.prog_u5_w1.services;

import mohamedjaouad.prog_u5_w1.entities.Utente;
import mohamedjaouad.prog_u5_w1.exceptions.duplications.UtenteDuplicatoException;
import mohamedjaouad.prog_u5_w1.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void save(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername())) {
            throw new UtenteDuplicatoException(utente.getUsername());
        }
        utenteRepository.save(utente);
    }


    public Utente findById(long id) {
        return utenteRepository.findById(id).orElseThrow();
    }
}
