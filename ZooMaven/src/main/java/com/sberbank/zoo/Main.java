package com.sberbank.zoo;

import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        Zoo zoo = null;
        try {
            zoo = new Zoo(args[0]);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }catch (JsonSyntaxException e) {
            e.printStackTrace();
            return;
        }

        PrintQuote("Zoo init");
        System.out.println(zoo.toString());

        zoo.getWatcher().feed(AnimalType.Herbivore);
        PrintQuote("Feed herbivore");
        System.out.println(zoo.toString());

        zoo.getWatcher().feed(AnimalType.Carnivore);
        PrintQuote("Feed carnivore");
        System.out.println(zoo.toString());

        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        PrintQuote("Night");
        System.out.println(zoo.toString());

        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Sun);
        PrintQuote("Sun");
        System.out.println(zoo.toString());

        Time.ChangeTime(Arrays.asList(zoo), TimeOfDay.Night);
        PrintQuote("Night");
        System.out.println(zoo.toString());

        Weather.Thunder(Arrays.asList(zoo));
        PrintQuote("Thunder");
        System.out.println(zoo.toString());
    }

    public static void PrintQuote(String str)
    {
        System.out.println("\n----------------------------\n" +
                           str +
                           "\n----------------------------\n");
    }
}
