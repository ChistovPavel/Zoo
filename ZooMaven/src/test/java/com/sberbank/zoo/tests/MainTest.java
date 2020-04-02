package com.sberbank.zoo.tests;

import com.sberbank.zoo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class MainTest extends Assert {

    Zoo zoo;

    @Before
    public void CreateZoo() throws FileNotFoundException {
        zoo = new Zoo("zoo.json");
    }

    @Test
    public void FeedCarnivoreTest(){
        reassureAnimals();
        zoo.getWatcher().feed(AnimalType.Carnivore);
        assertEquals(Arrays.asList(AnimalState.calm, AnimalState.calm),
                     Arrays.asList(AnimalsState(AnimalType.Carnivore),
                                   AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void FeedHerbivoreTest(){
        reassureAnimals();
        zoo.getWatcher().feed(AnimalType.Herbivore);
        assertEquals(Arrays.asList(AnimalState.noise, AnimalState.calm),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void FeedHerbivoreCarnivoreTest() {
        reassureAnimals();
        zoo.getWatcher().feed(AnimalType.Herbivore);
        zoo.getWatcher().feed(AnimalType.Carnivore);
        assertEquals(Arrays.asList(AnimalState.calm, AnimalState.calm),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void FeedCarnivoreHerbivoreTest(){
        reassureAnimals();
        zoo.getWatcher().feed(AnimalType.Carnivore);
        zoo.getWatcher().feed(AnimalType.Herbivore);
        assertEquals(Arrays.asList(AnimalState.noise, AnimalState.calm),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void SleepWithoutNoiseTest(){
        reassureAnimals();
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        assertEquals(Arrays.asList(AnimalState.sleep, AnimalState.sleep),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void SleepWithNoiseTest() {
        reassureAnimals();
        zoo.getWatcher().feed(AnimalType.Herbivore);
        List<AnimalState> expected = Arrays.asList(AnimalsState(AnimalType.Carnivore),
                                                   AnimalsState(AnimalType.Herbivore));
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        assertEquals(expected,
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void ThunderTest() {
        reassureAnimals();
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        Weather.Thunder(Arrays.asList(zoo));
        assertEquals(Arrays.asList(AnimalState.noise, AnimalState.noise),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Test
    public void WakeUpTest() {
        reassureAnimals();
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Sun);
        assertEquals(Arrays.asList(AnimalState.calm, AnimalState.calm),
                Arrays.asList(AnimalsState(AnimalType.Carnivore),
                        AnimalsState(AnimalType.Herbivore)));
    }

    @Ignore
    public void reassureAnimals()
    {
        zoo.getWatcher().feed(AnimalType.Herbivore);
        zoo.getWatcher().feed(AnimalType.Carnivore);
    }

    @Ignore
    public AnimalState AnimalsState(AnimalType type)
    {
        for (Animal animal : zoo.getAnimals())
        {
            if (type == AnimalType.Herbivore && animal instanceof Herbivore) return animal.getState();
            else if (type == AnimalType.Carnivore && animal instanceof Carnivore) return animal.getState();
        }
        return null;
    }
}
