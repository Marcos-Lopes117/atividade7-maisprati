package exercicio1;

public class MainExercicio1 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 1: Encapsulamento ---");
        try {
            Produto p1 = new Produto("Notebook", 2500.0, 10);
            System.out.println("Produto criado: " + p1);

            p1.setPreco(2350.50);
            p1.setQuantidadeEmEstoque(8);
            System.out.println("Produto alterado: " + p1);

            // Tentando atribuições inválidas
            System.out.println("\nTentando criar produto com nome inválido...");
            new Produto("", 100.0, 5);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando alterar preço para um valor negativo...");
            Produto p2 = new Produto("Mouse", 50.0, 20);
            p2.setPreco(-10.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando alterar quantidade em estoque para um valor negativo...");
            Produto p3 = new Produto("Teclado", 150.0, 15);
            p3.setQuantidadeEmEstoque(-5);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}