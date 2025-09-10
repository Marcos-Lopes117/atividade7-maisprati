package exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainExercicio3 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 3: Herança (Hierarquia de Funcionários) ---");
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Ana Paula", new BigDecimal("15000.00")));
        funcionarios.add(new Desenvolvedor("Ricardo Martins", new BigDecimal("8500.00")));
        funcionarios.add(new Gerente("João Costa", new BigDecimal("12000.00")));

        for (Funcionario f : funcionarios) {
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Salário: R$ " + f.getSalario());
            System.out.println("Bônus: R$ " + f.calcularBonus());
            System.out.println("--------------------");
        }
    }
}