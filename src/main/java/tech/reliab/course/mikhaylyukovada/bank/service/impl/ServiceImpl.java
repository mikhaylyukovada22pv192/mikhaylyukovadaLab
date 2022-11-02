package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.BankObject;
import tech.reliab.course.mikhaylyukovada.bank.service.Service;

/**
 * Реализация интерфейса с общими методами банковских сервисов
 *
 * @param <T> объекты банка
 */
public abstract class ServiceImpl<T extends BankObject> implements Service<T> {

    protected T model = null;

    @Override
    public T read() { return this.model; }

    @Override
    public void update(T model) {
        this.model = model;
    }

    @Override
    public void delete() {
        this.model = null;
    }
}
