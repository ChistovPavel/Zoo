package zoo.tests;

import animal.Action;
import animal.Animal;
import util.Observable;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest extends Assert {

    @Test(expected = NullPointerException.class)
    public void AnimalReactionNullObservableTest()
    {
        Animal animal = new Animal("zebra", 10);
        animal.reaction(null, Action.night);
    }

    @Test(expected = NullPointerException.class)
    public void AnimalReactionNullActionTest()
    {
        Observable observable = new Observable();
        Animal animal = new Animal("zebra", 10);
        animal.reaction(observable, null);
    }

    @Test
    public void AnimalReactionTest()
    {
        Observable observable = new Observable();
        Animal animal = new Animal("zebra", 10);
        animal.reaction(observable, Action.thunder);
        animal.reaction(observable, Action.sun);
        animal.reaction(observable, Action.night);
    }
}
