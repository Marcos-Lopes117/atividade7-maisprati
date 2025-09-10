package exercicio7;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MainExercicio7 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 7: Generics (Repositório Genérico) ---");

        // Usando o repositório com Produto
        InMemoryRepository<Produto, UUID> produtoRepository = new InMemoryRepository<>();
        Produto p1 = new Produto("Laptop", new BigDecimal("3500.00"));
        Produto p2 = new Produto("Celular", new BigDecimal("1800.00"));

        produtoRepository.salvar(p1);
        produtoRepository.salvar(p2);

        System.out.println("Todos os produtos: " + produtoRepository.listarTodos());

        Optional<Produto> produtoEncontrado = produtoRepository.buscarPorId(p1.getId());
        produtoEncontrado.ifPresent(p -> System.out.println("Produto encontrado: " + p));

        // Removendo um produto
        produtoRepository.remover(p2.getId());
        System.out.println("Após remover p2: " + produtoRepository.listarTodos());

        // Tentando remover um ID inexistente
        try {
            UUID idInexistente = UUID.randomUUID();
            produtoRepository.remover(idInexistente);
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Erro ao remover: " + e.getMessage());
        }

        System.out.println("\n--- Usando o repositório com Funcionario ---");
        InMemoryRepository<FuncionarioEx7, UUID> funcionarioRepository = new InMemoryRepository<>();
        FuncionarioEx7 f1 = new FuncionarioEx7("Maria", new BigDecimal("5000.00"));
        FuncionarioEx7 f2 = new FuncionarioEx7("Pedro", new BigDecimal("7500.00"));

        funcionarioRepository.salvar(f1);
        funcionarioRepository.salvar(f2);
        System.out.println("Todos os funcionários: " + funcionarioRepository.listarTodos());
    }
}