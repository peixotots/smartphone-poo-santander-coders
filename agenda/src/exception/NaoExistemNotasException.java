package exception;

public class NaoExistemNotasException extends RuntimeException {
    public NaoExistemNotasException(){ super("Não existem notas"); }
}
