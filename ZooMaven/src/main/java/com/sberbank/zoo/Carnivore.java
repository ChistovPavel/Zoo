package com.sberbank.zoo;

/**
 * Класс моделирует поведение плотоядных животных
 */
public class Carnivore extends Animal {

    /**
     * Конструктор класса {@link Carnivore}.
     * {@link Animal#Animal(String, Integer)}.
     */
    public Carnivore(String type, Integer count) {
        super(type, count);
    }

    /**
     * Метод Преобразует класс {@link Carnivore} к строке.
     * @return строка типа {@link String} формата {@link Animal#toString()} + "\nCarnivore".
     */
    @Override
    public String toString() {
        return super.toString() + "\nCarnivore";
    }

    /**
     * Переопределение метода equals.
     * @param obj объект для проверки.
     * @return true, если obj является объектом {@link AnimalType} и если obj равен {@link AnimalType#Carnivore}.
     * Во всех остальных случаях возвращает false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AnimalType && obj == AnimalType.Carnivore) return true;
        return false;
    }

    /**Переопределение метода, унаследованного ото класса {@link Animal}.
     * Данное переопределение позволяет реализовать поведение плотоядных животных.
     * @see Animal#reaction(Observable, Action)
     * @param observable объект класса {@link Observable}, который вызвал метод {@link Animal#reaction(Observable, Action)};
     * @param action событие {@link Action}, о котором объект класса {@link Observable} оповещает своих {@link Observer}.
     * */
    @Override
    public void reaction(Observable observable, Action action) {
        super.reaction(observable, action);

        if (((action == Action.feed_carnivore) || (action == Action.noise)) && (this.getState() != AnimalState.noise))
        {
            this.noise();
            observable.NotifyObservers(Action.noise);
        }
    }
}