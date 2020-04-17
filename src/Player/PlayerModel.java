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

    public void addResult(Categories category, int wynik) {
        wyniki.put(category, wynik);
    }

    public boolean containsCategory(Categories category) {
        if (wyniki.containsKey(category)) return false;
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

    public Integer getWynikiSize(){return wyniki.size();}





}


