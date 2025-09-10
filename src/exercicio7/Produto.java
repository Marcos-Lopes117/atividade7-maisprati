package exercicio7;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto implements Identificavel<UUID> {
    private final UUID id;
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}