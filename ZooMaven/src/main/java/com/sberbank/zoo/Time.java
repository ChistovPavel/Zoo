package com.sberbank.zoo;

import java.util.List;

/**
 * Класс моделирует время
 * */

public class Time {

    private static Time Instance;
    private static TimeOfDay time;

    static
    {
        Instance = new Time();
        time = TimeOfDay.Sun;
    }

    /**
     * конструктор класса {@link Time}
     * Данный класс реализует паттерн Singleton, поэтому конструктор private.
     * */
    private Time(){}
    /**
     * Метод возвращает объект класса.
     * @return объект {@link Time}.
     * */
    public static Time getInstance() {return Instance;}
    /**
     * Метод меняет время и производит оповещение "наблюдателей".
     * @param observables объект класса {@link Observable}. По средствам данного объекта происходит оповещение
     *                    "наблюдателей" о смене времени;
     * @param _time объект {@link TimeOfDay} содержит время. Текущее время будет заменено на время из _time.
     * */
    public static void ChangeTime(List<Observable> observables, TimeOfDay _time)
    {
        if (_time == null)
        {
            throw new NullPointerException();
        }
        time = _time;
        for (Observable observable : observables)
        {
            observable.NotifyObservers(Action.interpret(time));
        }
    }
    /**
     * Метод возвращает текущее время.
     * @return объект {@link TimeOfDay}, который содержит текущее время.
     * */
    public static TimeOfDay getTime(){return time;}
}