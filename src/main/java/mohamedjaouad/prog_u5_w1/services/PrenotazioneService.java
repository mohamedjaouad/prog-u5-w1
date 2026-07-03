package mohamedjaouad.prog_u5_w1.services;

import lombok.extern.slf4j.Slf4j;
import mohamedjaouad.prog_u5_w1.entities.Postazione;
import mohamedjaouad.prog_u5_w1.entities.Prenotazione;
import mohamedjaouad.prog_u5_w1.entities.Utente;
import mohamedjaouad.prog_u5_w1.exceptions.PostazioneOccupataException;
import mohamedjaouad.prog_u5_w1.exceptions.UtenteGiaPrenotatoException;
import mohamedjaouad.prog_u5_w1.exceptions.duplications.PrenotazioneDuplicataException;
import mohamedjaouad.prog_u5_w1.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Slf4j
@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione creaPrenotazione(Postazione postazione, Utente utente, LocalDate data) {

        if (prenotazioneRepository.existsByUtenteAndPostazioneAndDataPrenotazione(utente, postazione, data)) {
            throw new PrenotazioneDuplicataException(utente.getUsername(), postazione.getCodice(), data);
        }

        if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data)) {
            throw new PostazioneOccupataException(postazione.getCodice(), data);
        }

        if (prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data)) {
            throw new UtenteGiaPrenotatoException(utente.getUsername(), data);
        }


        Prenotazione nuova = new Prenotazione(data, utente, postazione);
        return prenotazioneRepository.save(nuova);
    }

}
