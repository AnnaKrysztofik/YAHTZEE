package main.Player;

import main.Enums.Categories;

import java.util.HashMap;
import java.util.Map;

public class PlayerModel {
    private String name;
    private Map<Categories, Integer> results;


    public PlayerModel(String name) {

        results = new HashMap<>();
        this.name = name;
    }

    public void addResult(Categories category, int wynik) {

        results.put(category, wynik);
    }

    public boolean containsCategory(Categories category) {

        if (results.containsKey(category)) {
            return false;
        } else {
            return true;
        }
    }


    public String getName() {

        return this.name;
    }

    public Integer getPointsByCategory(Categories category) {

        return this.results.get(category);
    }

    public Integer getSumaPunktow() {

        return results.values().stream().mapToInt(i -> i).sum();
    }

    public Integer getWynikiSize() {

        return results.size();
    }
}


