package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class MainExercicio4 {
    public static void main(String[] args) {
        System.out.println("--- Exercicio 4: Polimorfismo com Interface ---");
        List<IMeioTransporte> veiculos = new ArrayList<>();
        veiculos.add(new Carro());
        veiculos.add(new Bicicleta());
        veiculos.add(new Trem());

        for (IMeioTransporte veiculo : veiculos) {
            System.out.println("\nOperando " + veiculo.getClass().getSimpleName() + "...");
            veiculo.acelerar(5);
            veiculo.acelerar(10);
            veiculo.frear(8);
        }

        try {
            System.out.println("\nTentando operação inválida...");
            veiculos.get(0).acelerar(-1);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}