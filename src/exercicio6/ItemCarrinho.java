package exercicio6;
import java.math.BigDecimal;
import java.util.Objects;

public class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.produto = Objects.requireNonNull(produto);
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Dinheiro getSubtotal() {
        return new Dinheiro(produto.getPreco().getValor().multiply(new BigDecimal(quantidade)), produto.getPreco().getMoeda());
    }

    @Override
    public String toString() {
        return "ItemCarrinho{" +
                "produto=" + produto.getNome() +
                ", quantidade=" + quantidade +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}