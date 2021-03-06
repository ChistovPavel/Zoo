package zoo;

import animal.Action;
import util.Observable;

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
     * @param in_time объект {@link TimeOfDay} содержит время. Текущее время будет заменено на время из _time.
     * */
    public static void ChangeTime(List<Observable> observables, TimeOfDay in_time)
    {
        if (in_time == null)
        {
            throw new NullPointerException();
        }
        time = in_time;
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