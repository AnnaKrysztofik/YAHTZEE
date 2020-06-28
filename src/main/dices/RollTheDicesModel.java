package main.dices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RollTheDicesModel {


    public RollTheDicesModel() {
    }


    public Integer generateRollTheDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public List<Integer> nextDiceRoll(List<Integer> dicesInGame) {

        List<Integer> secondTimesThrowTheDice = new ArrayList<>();
        for (int i = 0; i < dicesInGame.size(); i++) {
            secondTimesThrowTheDice.add(dicesInGame.get(i));
        }
        for (int i = dicesInGame.size(); i < 5; i++) {
            secondTimesThrowTheDice.add(generateRollTheDice());
        }
        return secondTimesThrowTheDice;
    }
}







