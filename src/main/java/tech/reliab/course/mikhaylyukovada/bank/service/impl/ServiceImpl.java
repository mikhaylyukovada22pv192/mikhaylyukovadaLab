package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.BankObject;

/**
 * Реализация интерфейса с общими методами банковских сервисов
 *
 * @param <T> объекты банка
 */
public abstract class ServiceImpl<T extends BankObject> {

    protected T model = null;

    public T read() { return this.model; }

    public void update(T model) {
        this.model = model;
    }

    public void delete() {
        this.model = null;
    }
}
