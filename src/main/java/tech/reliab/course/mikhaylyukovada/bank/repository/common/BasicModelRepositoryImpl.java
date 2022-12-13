package tech.reliab.course.mikhaylyukovada.bank.repository.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса с базовыми методами для взаимодействия с объектами
 *
 * @param <T> объекты
 */
public abstract class BasicModelRepositoryImpl<T extends BasicModel> implements BasicModelRepository<T> {
    private long currentId = 1L;
    private final Map<Long, T> repository = new LinkedHashMap<>();

    public T add(T object) {
        if (object == null) { return null; }

        object.setId(currentId++);
        this.repository.put(object.getId(), object);
        return object;
    }

    public T update(T object) {
        if (object == null || !this.repository.containsKey(object.getId())) { return null; }

        this.repository.replace(object.getId(), object);
        return findById(object.getId());
    }

    public boolean deleteById(Long id) {
        if (!this.repository.containsKey(id)) { return false; }

        this.repository.remove(id);
        return true;
    }

    public T findById(Long id) {
        return this.repository.get(id);
    }

    public List<T> findAll() {
        return this.repository.values().stream().toList();
    }

}
