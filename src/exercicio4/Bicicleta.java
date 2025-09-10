package exercicio4;

public class Bicicleta implements IMeioTransporte {
    private double velocidadeAtual = 0;
    private static final double VELOCIDADE_MAX = 30;

    @Override
    public void acelerar(double intensidade) {
        if (intensidade <= 0) {
            throw new IllegalArgumentException("Intensidade deve ser positiva.");
        }
        this.velocidadeAtual += intensidade * 2;
        if (this.velocidadeAtual > VELOCIDADE_MAX) {
            this.velocidadeAtual = VELOCIDADE_MAX;
        }
        System.out.printf("Bicicleta acelerando. Velocidade atual: %.2f km/h.%n", this.velocidadeAtual);
    }

    @Override
    public void frear(double intensidade) {
        if (intensidade <= 0) {
            throw new IllegalArgumentException("Intensidade deve ser positiva.");
        }
        this.velocidadeAtual -= intensidade * 3;
        if (this.velocidadeAtual < 0) {
            this.velocidadeAtual = 0;
        }
        System.out.printf("Bicicleta freando. Velocidade atual: %.2f km/h.%n", this.velocidadeAtual);
    }
}