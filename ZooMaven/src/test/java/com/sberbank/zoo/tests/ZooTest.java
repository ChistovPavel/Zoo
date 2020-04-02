package com.sberbank.zoo.tests;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.sberbank.zoo.Zoo;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ZooTest extends Assert {

    @Test(expected = NullPointerException.class)
    public void ZooInitNullPathTest() throws FileNotFoundException, JsonIOException, JsonSyntaxException, NullPointerException {
        Zoo zoo = new Zoo(null);
    }
    @Test(expected = FileNotFoundException.class)
    public void ZooInitWrongPathTest() throws FileNotFoundException, JsonIOException, JsonSyntaxException, NullPointerException {
        Zoo zoo = new Zoo("WrongPath.json");
    }
    @Test(expected = JsonSyntaxException.class)
    public void ZooInitWrongSyntaxTest() throws FileNotFoundException, JsonIOException, JsonSyntaxException, NullPointerException {
        Zoo zoo = new Zoo("WrongSyntax.json");
    }
    @Test
    public void ZooInitTest() throws FileNotFoundException, JsonIOException, JsonSyntaxException, NullPointerException {
        Zoo zoo = new Zoo("zoo.json");
        assertNotNull(zoo);
    }
}
