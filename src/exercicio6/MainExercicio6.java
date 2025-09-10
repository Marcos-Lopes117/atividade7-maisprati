package exercicio6;

import java.math.BigDecimal;

public class MainExercicio6 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 6: Imutabilidade e Objetos de Valor ---");

        Dinheiro precoNotebook = new Dinheiro(new BigDecimal("2500.00"), Moeda.BRL);
        Produto notebook = new Produto("Notebook", precoNotebook);

        Carrinho carrinhoVazio = new Carrinho();
        System.out.println("Carrinho inicial: " + carrinhoVazio);

        // Adicionando um item (retorna um novo carrinho)
        Carrinho carrinhoComNotebook = carrinhoVazio.adicionarItem(new ItemCarrinho(notebook, 1));
        System.out.println("Após adicionar notebook: " + carrinhoComNotebook);

        // Aplicando um cupom de desconto (retorna outro novo carrinho)
        Carrinho carrinhoComDesconto = carrinhoComNotebook.aplicarCupom(new BigDecimal("10"));
        System.out.println("Após aplicar 10% de desconto: " + carrinhoComDesconto);

        // Tentando atribuição inválida
        try {
            carrinhoComDesconto.aplicarCupom(new BigDecimal("50"));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao aplicar cupom: " + e.getMessage());
        }
    }
}
