package mohamedjaouad.prog_u5_w1.exceptions.duplications;

public class UtenteDuplicatoException extends RuntimeException {
    public UtenteDuplicatoException(String username) {
        super("utente con username '" + username + "' esiste gia");
    }
}
