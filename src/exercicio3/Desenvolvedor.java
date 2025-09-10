package exercicio3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        // Bônus de 10% do salário
        return this.salario.multiply(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
    }
}