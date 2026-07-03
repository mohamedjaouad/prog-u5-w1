package mohamedjaouad.prog_u5_w1.exceptions.duplications;

import java.time.LocalDate;

public class PrenotazioneDuplicataException extends RuntimeException {
    public PrenotazioneDuplicataException(String username, String codice, LocalDate data) {
        super("La prenotazione per utente '" + username + "' postazione '" + codice +
                "' nella data " + data + " esiste gia");
    }
}
