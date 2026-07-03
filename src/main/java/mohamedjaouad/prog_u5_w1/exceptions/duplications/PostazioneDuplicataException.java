package mohamedjaouad.prog_u5_w1.exceptions.duplications;

public class PostazioneDuplicataException extends RuntimeException {
    public PostazioneDuplicataException(String codice) {
        super("La postazione con codice '" + codice + "' esiste gia");
    }
}