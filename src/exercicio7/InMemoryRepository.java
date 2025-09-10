package exercicio7;

import java.util.*;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();

    @Override
    public T salvar(T entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(storage.values()));
    }

    @Override
    public void remover(ID id) {
        if (!storage.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + id + " não encontrada.");
        }
        storage.remove(id);
    }
}