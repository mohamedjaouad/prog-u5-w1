package mohamedjaouad.prog_u5_w1.services;

import mohamedjaouad.prog_u5_w1.Enum.TipoPostazione;
import mohamedjaouad.prog_u5_w1.entities.Postazione;
import mohamedjaouad.prog_u5_w1.exceptions.duplications.PostazioneDuplicataException;
import mohamedjaouad.prog_u5_w1.repositories.PostazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void save(Postazione postazione) {

        if (postazioneRepository.existsByCodice(postazione.getCodice())) {
            throw new PostazioneDuplicataException(postazione.getCodice());
        }

        postazioneRepository.save(postazione);
    }


    public List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.cercaPerTipoECitta(tipo, citta.toLowerCase());
    }


}
