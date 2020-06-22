package zoo;

import animal.Action;
import util.Observable;

import java.util.List;

/**
 * Класс моделирует погоду
 * */

public class Weather {

    private static Weather Instance;

    static
    {
        Instance = new Weather();
    }

    /**
     * конструктор класса {@link Weather}
     * Данный класс реализует паттерн Singleton, поэтому конструктор private.
     * */
    private Weather(){}
    /**
     * Метод возвращает объект класса.
     * @return объект {@link Weather}.
     * */
    public static Weather getInstance() {return Instance;}

    /**
     * Метод моделирует гром и производит оповещение "наблюдателей".
     * @param observables объект класса {@link Observable}. По средствам данного объекта происходит оповещение
     *                    "наблюдателей" о громе.
     * */
    public static void Thunder(List<Observable> observables)
    {
        for (Observable observable : observables)
        {
            observable.NotifyObservers(Action.thunder);
        }
    }
}