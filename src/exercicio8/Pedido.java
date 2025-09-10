package exercicio8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cepDestino;
    private final List<BigDecimal> itensValor;

    public Pedido(String cepDestino) {
        this.cepDestino = cepDestino;
        this.itensValor = new ArrayList<>();
    }

    public void adicionarItem(BigDecimal valor) {
        this.itensValor.add(valor);
    }

    public BigDecimal calcularTotalItens() {
        return itensValor.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getCepDestino() {
        return cepDestino;
    }
}