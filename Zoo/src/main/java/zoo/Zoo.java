package zoo;

import animal.Animal;
import animal.Carnivore;
import animal.Herbivore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import util.AnimalDeserialize;
import util.Observable;
import util.Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс моделирует зоопарк
 * */

public class Zoo extends Observable {

    private List<Animal> animals;
    private Watcher watcher;

    /**
     * Конструктор класса {@link Zoo}.
     * @param Path строка, которая содержит путь к JSON файл. В данном файле хранится информация о животных,
     *             которые находятся в зоопарке.
     * @exception NullPointerException при Path равном null;
     * @exception FileNotFoundException при отсуствии файла по пути Path;
     * @exception com.google.gson.JsonSyntaxException при ошибке парсинга JSON файла.
     * */
    public Zoo(String Path) throws NullPointerException,
                                   FileNotFoundException,
                                   com.google.gson.JsonSyntaxException
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        JsonReader jsonReader = new JsonReader(new FileReader(new File(Path)));
        AnimalDeserialize animalDeserialize = gson.fromJson(jsonReader, AnimalDeserialize.class);

        this.watcher = new Watcher(this);
        this.animals = new ArrayList<>();

        addAnimals(animalDeserialize.getCarnivores());
        addAnimals(animalDeserialize.getHerbivores());
    }

    public List<Animal> getAnimals(){return this.animals;}
    public Watcher getWatcher(){return this.watcher;}

    private void addAnimals(List<?> animals)
    {
        for (Object animal : animals)
        {
            if (animal instanceof Herbivore || animal instanceof Carnivore)
            {
                this.animals.add((Animal) animal);
                this.addObserver((Observer) animal);
            }
        }
    }
    /**
     * Метод Преобразует класс {@link Zoo} к строке.
     * @return строка типа {@link String}. Формат: совокупность строк {@link Herbivore#toString()} или {@link Carnivore#toString()}.
     */
    @Override
    public String toString() {
        String str = "";
        for (Animal animal : this.animals)
        {
            str += animal.toString() + "\n";
        }
        return str;
    }
}
