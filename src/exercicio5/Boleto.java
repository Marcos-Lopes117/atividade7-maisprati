package exercicio5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBarra;

    public Boleto(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Override
    public void validarPagamento() {
        if (codigoBarra == null || codigoBarra.length() != 47) {
            throw new PagamentoInvalidoException("Código de barra do boleto inválido.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) {
        validarPagamento();
        System.out.printf("Pagamento de R$ %.2f processado via Boleto. Código de barras: %s.%n", valor, codigoBarra);
    }
}