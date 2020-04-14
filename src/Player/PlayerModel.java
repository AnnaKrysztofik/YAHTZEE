package Player;

import Enums.Categories;

import java.util.HashMap;
import java.util.Map;

public class PlayerModel {
    private String name;
    private Map<Categories, Integer> wyniki;


    public PlayerModel(String name) {
        wyniki = new HashMap<>();
        this.name = name;
    }

    public boolean addResult(Categories category, int wynik) {
        if (wyniki.containsKey(category)) return false;
        wyniki.put(category, wynik);
        return true;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPointsByCategory(Categories category) {
        return this.wyniki.get(category);
    }

    public Integer getSumaPunktow() {
       return wyniki.values().stream().mapToInt(i->i).sum();
    }



}


