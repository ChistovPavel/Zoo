package zoo.tests;

import zoo.Time;
import zoo.TimeOfDay;
import zoo.Zoo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TimeTest extends Assert {

    Zoo zoo = null;

    @Before
    public void CreateZoo() throws FileNotFoundException {
        zoo = new Zoo("zoo.json");
    }

    @Test(expected = NullPointerException.class)
    public void NullListObservableTest()
    {
        Time.ChangeTime(null, TimeOfDay.Night);
    }

    @Test
    public void NotNullListObservableTest() {
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
    }

    @Test (expected = NullPointerException.class)
    public void NullTimeTest() {
        Time.ChangeTime(Arrays.asList(zoo), null);
    }

    @Test
    public void getInstanceTest()
    {
        Time time = Time.getInstance();
        assertNotNull(time);
    }

    @Test
    public void getTimeTest()
    {
        assertNotNull(Time.getTime());
    }
}
