package mohamedjaouad.prog_u5_w1.exceptions.duplications;

public class EdificioDuplicatoException extends RuntimeException {
    public EdificioDuplicatoException(String nome, String indirizzo) {
        super("edificio '" + nome + "' in '" + indirizzo + "' esiste gia");
    }
}
