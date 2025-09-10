package exercicio8;

import java.math.BigDecimal;

public class MainExercicio8 {

    // Estratégias de frete implementadas como lambdas
    public static final CalculadoraFrete FRETE_SEDEX = pedido -> {
        // Frete fixo, por exemplo, R$ 20,00
        return new BigDecimal("20.00");
    };

    public static final CalculadoraFrete FRETE_PAC = pedido -> {
        // Frete mais barato, por exemplo, 10% do valor total dos itens
        return pedido.calcularTotalItens().multiply(new BigDecimal("0.10"));
    };

    public static final CalculadoraFrete RETIRADA_NA_LOJA = pedido -> {
        return BigDecimal.ZERO;
    };

    public static void main(String[] args) {
        System.out.println("--- Exercicio 8: Padrão Strategy (Cálculo de Frete) ---");

        Pedido pedido1 = new Pedido("20000-000");
        pedido1.adicionarItem(new BigDecimal("150.00"));
        pedido1.adicionarItem(new BigDecimal("80.00"));

        System.out.println("Total dos itens: R$ " + pedido1.calcularTotalItens());

        // Calculando frete com diferentes estratégias
        BigDecimal freteSedex = FRETE_SEDEX.calcular(pedido1);
        System.out.println("Frete SEDEX: R$ " + freteSedex);

        BigDecimal fretePac = FRETE_PAC.calcular(pedido1);
        System.out.println("Frete PAC: R$ " + fretePac);

        BigDecimal freteRetirada = RETIRADA_NA_LOJA.calcular(pedido1);
        System.out.println("Frete Retirada na Loja: R$ " + freteRetirada);

        // Estratégia promocional via lambda
        CalculadoraFrete fretePromocional = pedido -> {
            if (pedido.calcularTotalItens().compareTo(new BigDecimal("200.00")) > 0) {
                return BigDecimal.ZERO; // Frete grátis acima de R$ 200
            } else {
                return FRETE_PAC.calcular(pedido);
            }
        };

        System.out.println("\nCalculando frete com estratégia promocional...");
        BigDecimal fretePedido1 = fretePromocional.calcular(pedido1); // Valor total é 230
        System.out.println("Frete promocional: R$ " + fretePedido1);

        Pedido pedido2 = new Pedido("20000-000");
        pedido2.adicionarItem(new BigDecimal("50.00"));
        BigDecimal fretePedido2 = fretePromocional.calcular(pedido2); // Valor total é 50
        System.out.println("Frete para pedido abaixo do limite: R$ " + fretePedido2);
    }
}