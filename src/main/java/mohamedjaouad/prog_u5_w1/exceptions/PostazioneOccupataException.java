package mohamedjaouad.prog_u5_w1.exceptions;

import java.time.LocalDate;

public class PostazioneOccupataException extends RuntimeException {
    public PostazioneOccupataException(String codice, LocalDate data) {
        super("La postazione '" + codice + "' e gia occupata nella data " + data );
    }
}