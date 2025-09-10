package exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal cupomDesconto;

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.cupomDesconto = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal cupomDesconto) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.cupomDesconto = cupomDesconto;
    }

    public Carrinho adicionarItem(ItemCarrinho novoItem) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.add(novoItem);
        return new Carrinho(novosItens, this.cupomDesconto);
    }

    public Carrinho removerItem(Produto produtoParaRemover) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.removeIf(item -> item.getProduto().equals(produtoParaRemover));
        return new Carrinho(novosItens, this.cupomDesconto);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagemDesconto) {
        if (porcentagemDesconto.compareTo(BigDecimal.ZERO) < 0 || porcentagemDesconto.compareTo(new BigDecimal("30")) > 0) {
            throw new IllegalArgumentException("Cupom de desconto deve estar entre 0 e 30%.");
        }
        return new Carrinho(this.itens, porcentagemDesconto);
    }

    public Dinheiro calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : itens) {
            total = total.add(item.getSubtotal().getValor());
        }

        BigDecimal valorDesconto = total.multiply(this.cupomDesconto.divide(new BigDecimal("100")));
        total = total.subtract(valorDesconto).setScale(2, RoundingMode.HALF_UP);

        return new Dinheiro(total, Moeda.BRL);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "itens=" + itens +
                ", cupomDesconto=" + cupomDesconto +
                "%, total=" + calcularTotal() +
                '}';
    }
}