package exercicio5;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() {
        if (chavePix == null || !Pattern.matches("^[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+|[0-9]{11}$", chavePix)) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.printf("Pagamento de R$ %.2f processado via Pix. Chave: %s.%n", valor, chavePix);
    }
}