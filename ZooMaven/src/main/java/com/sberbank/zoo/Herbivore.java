package com.sberbank.zoo;

/**
 * Класс моделирует поведение травоядных животных
 */
public class Herbivore extends Animal {

    /**
     * Конструктор класса {@link Herbivore}.
     * {@link Animal#Animal(String, Integer)}.
     */
    public Herbivore(String type, Integer count) {
        super(type, count);
    }

    /**
     * Метод Преобразует класс {@link Herbivore} к строке.
     * @see Animal#toString()
     * @return строка типа {@link String} формата {@link Animal#toString()} + "\nHerbivore".
     */
    @Override
    public String toString() {
        return super.toString() + "\nHerbivore";
    }

    /**
     * Переопределение метода equals.
     * @param obj объект для проверки.
     * @return true, если obj является объектом {@link AnimalType} и если obj равен {@link AnimalType#Herbivore}.
     * Во всех остальных случаях возвращает false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AnimalType && obj == AnimalType.Herbivore) return true;
        return false;
    }

    /**Переопределение метода, унаследованного ото класса {@link Animal}.
     * Данное переопределение позволяет реализовать поведение травоядных животных.
     * @see Animal#reaction(Observable, Action)
     * @param observable объект класса {@link Observable}, который вызвал метод {@link Animal#reaction(Observable, Action)};
     * @param action событие {@link Action}, о котором объект класса {@link Observable} оповещает своих {@link Observer}.
     * */
    @Override
    public void reaction(Observable observable, Action action) {
        super.reaction(observable, action);
        if ((action == Action.feed_herbivore) && (this.getState() != AnimalState.noise))
        {
                this.noise();
                observable.NotifyObservers(Action.noise);
        }
    }
}
