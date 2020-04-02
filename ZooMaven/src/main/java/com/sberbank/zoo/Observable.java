package com.sberbank.zoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, позволяющий реализовать паттерн разработки "Наблюдатель"
 * */

public class Observable {
    private List<Observer> observers;

    /**Конструктор класса {@link Observable}.*/
    public Observable(){this.observers = new ArrayList<>();}

    /**
     * Добавление "наблюдателя" в список для оповещения.
     * @param obs объект, реализующий интерфейс {@link Observer}.
     * */
    public void addObserver(Observer obs){this.observers.add(obs);}
    /**
     * Удаление "наблюдателя" из списока оповещения.
     * @param i индекс объект в списке оповещения.
     * */
    public void deleteObserver(Integer i){this.observers.remove(i);}
    /**
     * Удаление "наблюдателя" из списока оповещения.
     * @param obs объект списке оповещения.
     * */
    public void deleteObserver(Observer obs){this.observers.remove(obs);}

    /**
     * Оповещение "наблюдателей" об наступлении определенного события {@link Action}.
     * @param action событие.
     * */
    public void NotifyObservers(Action action)
    {
        for (Observer observer : this.observers)
        {
            observer.reaction(this, action);
        }
    }

    /**
     * Опрос "наблюдателей".
     * @param obj содержит условие опроса.
     * @return true, если хотя бы у одного из "наблюдателей" условие опроса оказалось истинно. Если у всех
     * "наблюдателей" условие оказалось ложно, то возвращает false.
     * */
    public boolean CheckObservers(Object obj)
    {
        for (Observer observer : this.observers)
        {
            if (observer.reaction(obj) == true) return true;
        }
        return false;
    }
}
