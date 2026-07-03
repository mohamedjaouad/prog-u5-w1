package mohamedjaouad.prog_u5_w1.runners;

import mohamedjaouad.prog_u5_w1.Enum.TipoPostazione;
import mohamedjaouad.prog_u5_w1.entities.Edificio;
import mohamedjaouad.prog_u5_w1.entities.Postazione;
import mohamedjaouad.prog_u5_w1.entities.Utente;
import mohamedjaouad.prog_u5_w1.services.EdificioService;
import mohamedjaouad.prog_u5_w1.services.PostazioneService;
import mohamedjaouad.prog_u5_w1.services.PrenotazioneService;
import mohamedjaouad.prog_u5_w1.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RUNNER implements CommandLineRunner {

    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final UtenteService utenteService;
    private final PrenotazioneService prenotazioneService;

    public RUNNER(
            EdificioService edificioService,
            PostazioneService postazioneService,
            UtenteService utenteService,
            PrenotazioneService prenotazioneService
    ) {
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) throws Exception {

        Edificio e1 = new Edificio("Sede Centrale", "Via Roma 10", "Modena");
        Edificio e2 = new Edificio("Palazzo Nord", "Via Milano 22", "Milano");
        Edificio e3 = new Edificio("Campus Sud", "Via Bari 5", "Bologna");

        try { edificioService.save(e1); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { edificioService.save(e2); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { edificioService.save(e3); } catch (Exception ex) { System.out.println(ex.getMessage()); }

        Postazione p1 = new Postazione("PZ-001", "Postazione privata", TipoPostazione.PRIVATO, 1, e1);
        Postazione p2 = new Postazione("PZ-002", "Open space luminoso", TipoPostazione.OPENSPACE, 4, e1);
        Postazione p3 = new Postazione("PZ-003", "Sala riunioni grande", TipoPostazione.SALA_RIUNIONI, 10, e2);
        Postazione p4 = new Postazione("PZ-004", "Postazione tranquilla", TipoPostazione.PRIVATO, 1, e3);

        try { postazioneService.save(p1); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { postazioneService.save(p2); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { postazioneService.save(p3); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { postazioneService.save(p4); } catch (Exception ex) { System.out.println(ex.getMessage()); }

        Utente u1 = new Utente("mohamed", "Mohamed Jaouad", "mohamed@example.com");
        Utente u2 = new Utente("giulia", "Giulia Rossi", "giulia@example.com");
        Utente u3 = new Utente("luca", "Luca Bianchi", "luca@example.com");
        Utente u4 = new Utente("anna", "Anna Verdi", "anna@example.com");

        try { utenteService.save(u1); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { utenteService.save(u2); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { utenteService.save(u3); } catch (Exception ex) { System.out.println(ex.getMessage()); }
        try { utenteService.save(u4); } catch (Exception ex) { System.out.println(ex.getMessage()); }

        try {
            prenotazioneService.creaPrenotazione(p1, u1, LocalDate.now().plusDays(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            prenotazioneService.creaPrenotazione(p1, u1, LocalDate.now().plusDays(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            prenotazioneService.creaPrenotazione(p2, u1, LocalDate.now().plusDays(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        postazioneService.cercaPerTipoECitta(TipoPostazione.PRIVATO, "bologna")
                .forEach(p -> System.out.println(
                        p.getCodice() + " - " +
                                p.getDescrizione() + " - " +
                                p.getEdificio().getNome() + " - " +
                                p.getEdificio().getCitta()
                ));
    }
}
