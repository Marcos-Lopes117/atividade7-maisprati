package exercicio5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainExercicio5 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 5: Abstração (Sistema de Pagamentos) ---");

        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567890123456", "João Silva"));
        pagamentos.add(new Boleto("12345678901234567890123456789012345678901234567"));
        pagamentos.add(new Pix("joao.silva@email.com"));

        BigDecimal valorCompra = new BigDecimal("150.75");

        for (FormaPagamento forma : pagamentos) {
            System.out.println("\nProcessando pagamento com " + forma.getClass().getSimpleName() + "...");
            try {
                forma.processarPagamento(valorCompra);
            } catch (PagamentoInvalidoException e) {
                System.err.println("Erro de validação: " + e.getMessage());
            }
        }

        // Testando validação inválida
        System.out.println("\nTentando processar pagamento com cartão inválido...");
        CartaoCredito cartaoInvalido = new CartaoCredito("12345", "Nome Teste");
        try {
            cartaoInvalido.processarPagamento(new BigDecimal("100.00"));
        } catch (PagamentoInvalidoException e) {
            System.err.println("Erro de validação: " + e.getMessage());
        }
    }
}