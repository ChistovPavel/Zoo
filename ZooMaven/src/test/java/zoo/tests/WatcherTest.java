package zoo.tests;

import animal.AnimalType;
import zoo.Watcher;
import zoo.Zoo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class WatcherTest extends Assert {

    private Zoo zoo;

    @Before
    public void CreateZoo() throws FileNotFoundException {
        this.zoo = new Zoo("zoo.json");
    }

    @Test (expected = NullPointerException.class)
    public void CreateWatcherNullZooTest() throws NullPointerException
    {
        Watcher watcher = new Watcher(null);
    }

    @Test (expected = NullPointerException.class)
    public void FeedNullAnimalsTest() throws NullPointerException {
        zoo.getWatcher().feed(null);
    }

    @Test
    public void FeedAnimalsTest() throws NullPointerException {
        zoo.getWatcher().feed(AnimalType.Herbivore);
        zoo.getWatcher().feed(AnimalType.Carnivore);
    }
}
