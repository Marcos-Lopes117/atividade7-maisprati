package exercicio7;

import exercicio3.Funcionario; // Usa o abstrato do exercício 3
import java.math.BigDecimal;
import java.util.UUID;

public class FuncionarioEx7 extends Funcionario implements Identificavel<UUID> {
    private final UUID id;

    public FuncionarioEx7(String nome, BigDecimal salario) {
        super(nome, salario); // Chama o construtor da classe abstrata
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public BigDecimal calcularBonus() {
        // Implementação específica do exercício 7
        // Exemplo: 10% do salário
        return salario.multiply(new BigDecimal("0.10"));
    }

    @Override
    public String toString() {
        return "FuncionarioEx7{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", bonus=" + calcularBonus() +
                '}';
    }
}
