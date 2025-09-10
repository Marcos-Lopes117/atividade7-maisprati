package exercicio2;

import exercicio1.Produto; // Importando a classe do Exercicio 1

public class ProdutoComDesconto extends Produto {
    public ProdutoComDesconto(String nome, double preco, int quantidadeEmEstoque) {
        super(nome, preco, quantidadeEmEstoque);
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("A porcentagem de desconto deve ser entre 0 e 50.");
        }
        double novoPreco = getPreco() * (1 - porcentagem / 100);
        setPreco(novoPreco); // Usa o setter da classe pai
    }
}