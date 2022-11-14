package tech.reliab.course.mikhaylyukovada.bank.repository.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.BankObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса с методами для взаимодейтсвия с банковскими объектами
 *
 * @param <T> объекты банка
 */
public abstract class BankObjectRepositoryImpl<T extends BankObject> implements BankObjectRepository<T>{

    private long currentId = 1L;
    private final Map<Long, T> repository = new LinkedHashMap<>();

    public T add(T object) {
        if (object == null) { return null; }

        object.setId(currentId++);
        this.repository.put(object.getId(), object);
        return object;
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

    public T update(T object) {
        if (object == null || !this.repository.containsKey(object.getId())) { return null; }

        this.repository.replace(object.getId(), object);
        return findById(object.getId());
    }
}
