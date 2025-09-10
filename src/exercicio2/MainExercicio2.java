package exercicio2;

public class MainExercicio2 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 2: Encapsulamento com Desconto ---");
        try {
            ProdutoComDesconto p = new ProdutoComDesconto("Smartwatch", 1200.0, 5);
            System.out.println("Preço original do " + p.getNome() + ": " + p.getPreco());

            p.aplicarDesconto(15.0);
            System.out.println("Preço com 15% de desconto: " + p.getPreco());

            System.out.println("\nTentando aplicar desconto inválido (60%)...");
            p.aplicarDesconto(60.0);
        } catch (DescontoInvalidoException e) {
            System.err.println("Erro ao aplicar desconto: " + e.getMessage());
        }
    }
}