package exercicio4;

public class Trem implements IMeioTransporte {
    private double velocidadeAtual = 0;
    private static final double VELOCIDADE_MAX = 120;

    @Override
    public void acelerar(double intensidade) {
        if (intensidade <= 0) {
            throw new IllegalArgumentException("Intensidade deve ser positiva.");
        }
        this.velocidadeAtual += intensidade * 8;
        if (this.velocidadeAtual > VELOCIDADE_MAX) {
            this.velocidadeAtual = VELOCIDADE_MAX;
        }
        System.out.printf("Trem acelerando. Velocidade atual: %.2f km/h.%n", this.velocidadeAtual);
    }

    @Override
    public void frear(double intensidade) {
        if (intensidade <= 0) {
            throw new IllegalArgumentException("Intensidade deve ser positiva.");
        }
        this.velocidadeAtual -= intensidade * 15;
        if (this.velocidadeAtual < 0) {
            this.velocidadeAtual = 0;
        }
        System.out.printf("Trem freando. Velocidade atual: %.2f km/h.%n", this.velocidadeAtual);
    }
}