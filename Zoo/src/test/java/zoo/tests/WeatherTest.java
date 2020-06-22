package zoo.tests;

import zoo.Weather;
import zoo.Zoo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class WeatherTest extends Assert {

    Zoo zoo = null;

    @Before
    public void CreateZoo() throws FileNotFoundException {
        zoo = new Zoo("zoo.json");
    }

    @Test(expected = NullPointerException.class)
    public void NullListObservableTest()
    {
        Weather.Thunder(null);
    }

    @Test
    public void NotNullListObservableTest() throws FileNotFoundException {
        Weather.Thunder(Arrays.asList(zoo));
    }

    @Test
    public void getInstanceTest()
    {
        Weather weather = Weather.getInstance();
        assertNotNull(weather);
    }
}
