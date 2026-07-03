package mohamedjaouad.prog_u5_w1.exceptions;

import java.time.LocalDate;

public class UtenteGiaPrenotatoException extends RuntimeException {
    public UtenteGiaPrenotatoException(String username, LocalDate data) {
        super("utente '" + username + "' ha gia una prenotazione nella data " + data);
    }
}
