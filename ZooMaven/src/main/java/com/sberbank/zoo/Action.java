package com.sberbank.zoo;

/**
 * enum класс содержит все возможные события в зоопарке
 */
public enum Action {
    /**Смотритель идет кормить плотоядных*/
    feed_carnivore,
    /**Смотритель идет кормить травоядных*/
    feed_herbivore,
    /**Животные начинают шуметь*/
    noise,
    /**Прогремел гром*/
    thunder,
    /**Наступило утро*/
    sun,
    /**Наступила ночь*/
    night;

    /***
     * Преобразование в объекта {@link AnimalType} к объекту {@link Action}.
     * @param animalType объект {@link AnimalType}.
     * @return объект {@link Action}, если на входе был получен объект {@link TimeOfDay} или {@link AnimalType}, и null,
     *         если был получен какой-либо другой объект.
     */
    public static Action interpret(AnimalType animalType)
    {
        if (animalType == AnimalType.Herbivore) return feed_herbivore;
        return feed_carnivore;
    }

    /***
     * Преобразование объекта {@link TimeOfDay} к объекту {@link Action}.
     * @param timeOfDay объект {@link TimeOfDay}.
     * @return объект {@link Action}, если на входе был получен объект {@link TimeOfDay} или {@link AnimalType}, и null,
     *         если был получен какой-либо другой объект.
     */
    public static Action interpret(TimeOfDay timeOfDay)
    {
        if (timeOfDay == TimeOfDay.Sun) return sun;
        return night;
    }

}
