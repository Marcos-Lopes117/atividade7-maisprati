package exercicio2;

public class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException(String message) {
        super(message);
    }
}