package util;

import animal.Action;

/**
 * Интерфейс, позволяющий реализовать паттерн разработки "Наблюдатель"
 * */
public interface Observer {
    /**
     * Метод, позволяющий оповещать наблюдателей о наступлении определенного события.
     * @param observable объект {@link Observable}, который вызвал метод {@link Observer#reaction(Observable, Action)};
     * @param action событие {@link Action}, о котором объект класса {@link Observable} оповещает своих {@link Observer}.
     */
    public void reaction(Observable observable, Action action);
    /**
     * Метод, позволяющий опрашивать наблюдателей.
     * @param obj объект содержит условие опроса.
     * @return true, если условие выполнилось, или false, если условие не выполнилось.
     */
    public boolean reaction(Object obj);
}
