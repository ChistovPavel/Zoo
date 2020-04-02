package com.sberbank.zoo;

/**
 * Класс моделирует поведение смотрителя зоопарка
 * */

public class Watcher {

    private Zoo zoo;

    /**
     * Конструктор класса {@link Watcher}.
     * @param zoo объект {@link Zoo}, за которым следит смотритель {@link Watcher}.
     * */
    public Watcher(Zoo zoo) {
        if (zoo == null)
        {
            throw new NullPointerException();
        }
        this.zoo = zoo;
    }
    /**
     * Покормить животных.
     * @param type объект {@link AnimalType}, который содержит тип животных, которых нужно кормить.
     * */
    public void feed(AnimalType type)
    {
        if (type == null)
        {
            throw new NullPointerException();
        }
        zoo.NotifyObservers(Action.interpret(type));

        for (Animal animal : zoo.getAnimals())
        {
            if (animal.equals(type)) animal.eat();
        }
    }
}