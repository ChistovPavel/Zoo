package com.sberbank.zoo;
/**
 * Класс содержит информацию о животных, моделирует их поведение
 */
public class Animal implements Observer{
    /**вид животного (например Лев, тигр, зебра, слон)*/
    private String type;
    /**количество животоных определенного типа*/
    private Integer count;
    /**описание состояния животного*/
    private AnimalState state;

    /**
     * Конструктор класса {@link Animal}.
     * При создании животоного, состояние всегда будет {@link AnimalState#calm}.
     * @param in_type вид животного (например Лев, тигр, зебра, слон);
     * @param in_count количество животоных определенного типа.
     */
    public Animal (String in_type, Integer in_count)
    {
        this.type = in_type;
        this.count = in_count;
        this.state = AnimalState.calm;
    }

    /**
     * Метод запроса состояния животного {@link AnimalState}.
     * @return объект {@link AnimalState}, в котором описано состояние животоного.
     */
    public final AnimalState getState(){return this.state;}

    /**
     * Метод Преобразует класс {@link Animal} к строке.
     * @return строка типа {@link String} формата "Type: {@link String}\nCount: {@link Integer}\nState: {@link AnimalState}."
     */
    public String toString()
    {
        return "Type: " + this.type +
                "\nCount: " + this.count +
                "\nState: " + this.state;
    }

    /**Процесс питания животного.
     * Метод устанавливает состояние животного {@link Animal#state} в состояние {@link AnimalState#calm}.*/
    public void eat(){this.state = AnimalState.calm;}
    /**Животное начинает шуметь.
     * Метод устанавливает состояние животного {@link Animal#state} в состояние {@link AnimalState#noise}.*/
    public void noise(){this.state = AnimalState.noise;}
    /**Животное засыпает.
     * Метод устанавливает состояние животного {@link Animal#state} в состояние {@link AnimalState#sleep}.*/
    public void sleep(){this.state = AnimalState.sleep;}
    /**Животное просыпается.
     * Метод устанавливает состояние животного {@link Animal#state} в состояние {@link AnimalState#calm}.*/
    public void wakeup(){this.state = AnimalState.calm;}

    /**Метод, унаследованные от интерфейса {@link Observer}.
     *Благодаря реализации интерфейса {@link Observer}, возможно оповещение определенных объектов о некотором событии {@link Action}.
     *В данном случае происходит оповещение животного, о наступлении какого либо события {@link Action} в зоопарке {@link Zoo}.
     *
     * @param observable объект класса {@link Observable}, который вызвал метод {@link Animal#reaction(Observable, Action)};
     * @param action событие {@link Action}, о котором объект класса {@link Observable} оповещает своих {@link Observer}.
     * */
    @Override
    public void reaction(Observable observable, Action action) {
        switch (action)
        {
            case thunder:
                if (this.state == AnimalState.sleep) this.noise();
                break;
            case sun:
                if (this.state == AnimalState.sleep) this.wakeup();
                break;
            case night:
                if (observable.CheckObservers(AnimalState.noise) == false)this.sleep(); /*
                                                                                            При наступлении ночи, текущее животное
                                                                                            опрашивает других животных об их состоянии.
                                                                                            Если все жживотные спокойны, то текущее животное
                                                                                            ложится спать.
                                                                                        */
                break;
        }
    }

    /**Метод, унаследованные от интерфейса {@link Observer}.
     *Благодаря реализации интерфейса {@link Observer}, возможно оповещение определенных объектов о некотором событии {@link Action}.
     *В данном случае происходит опрос животного, о его состоянии {@link AnimalState}.
     *
     * @param obj объект содержит состояние, о котором происходит опрос.
     * @return true, если состояние obj совпало с состоянием животного, и false, если состояния не совпали.
     * */
    @Override
    public boolean reaction(Object obj) {
        if (obj instanceof AnimalState && this.state == obj) return true;
        return false;
    }
}
