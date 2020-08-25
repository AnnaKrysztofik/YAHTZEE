package main;

import main.Enums.Categories;
import main.dices.RollTheDicesModel;
import main.Player.PlayerModel;
import main.Points.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameManager {

    private PlayerModel player1;
    private PlayerModel player2;
    private PlayerModel current;
    UserInterface userInterface = new UserInterface();
    RollTheDicesModel rollTheDicesModel;
    private List<Integer> dicesInGame;

    List<PointsCalculateStrategyInterface> pointsCounterStrategies = List.of(
            new SinglesCalculateStrategy(),
            new ThreeCalculateStrategy(),
            new FourCalculateStrategy(),
            new FullCalculateStrategy(),
            new SmallStraightCalculateStrategy(),
            new LargeStraightCalculateStrategy(),
            new YahtzeeCalculateStrategy(),
            new ChanceCalculateStrategy()
    );

    public GameManager() {

        player1 = new PlayerModel("Gracz 1");
        player2 = new PlayerModel("Gracz 2");
        current = player1;
        rollTheDicesModel = new RollTheDicesModel();
        dicesInGame = new ArrayList<>();
    }

    private void nextPlayer() {
        if (current == player1)
            current = player2;
        else current = player1;
    }

    public void courseOfGame() {
        userInterface.welcomeScreen();
        userInterface.yoursName(player1, player2);
        userInterface.gameStatus(player1, player2);
        do {
            userInterface.displayPlayer(current);
            dicesInGame.clear();
            List<Integer> discardedDice = rollTheRemainingDice("pierwszego", dicesInGame);
            List<Integer> discardedDice2 = keepAndRoll("drugiego", discardedDice);
            List<Integer> discardedDice3 = keepAndRoll("trzeciego", discardedDice2);

           Categories choseCategory;
            do
                {
                choseCategory = selectCategories();
                userInterface.categoryIsTaken();
                } while (current.containsCategory(choseCategory) == false);

           addPointsToTable(choseCategory, discardedDice3);
           nextPlayer();
        } while (endOfGame() == false);
    }

    public int calculatePoints(Categories category, List<Integer> dices) {

        return pointsCounterStrategies.stream()
                .filter(s -> s.canCalculate(category))
                .mapToInt(s -> s.calculate(category, dices))
                .sum();
    }

    public List<Integer> listOfDicesInGame(List<String> lisOfLetters, List<Integer> discardedDice) {

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < lisOfLetters.size(); i++) {
            switch (lisOfLetters.get(i)) {
                case "A":
                    myList.add(discardedDice.get(0));
                    break;
                case "B":
                    myList.add(discardedDice.get(1));
                    break;
                case "C":
                    myList.add(discardedDice.get(2));
                    break;
                case "D":
                    myList.add(discardedDice.get(3));
                    break;
                case "E":
                    myList.add(discardedDice.get(4));
                    break;
            }
        }
        return myList;
    }

    public List<String> createListOfLetters(String letters) {

        String[] letter = letters.split(",", 5);
        return Stream.of(letter).map(s -> s.toUpperCase()).collect(Collectors.toList());
    }


    public List<Integer> generateRollOfDice(List<Integer> discardedDice) {

        String letters = userInterface.inscriptionChooseDices();
        List<String> lisOfLetters = createListOfLetters(letters);
        dicesInGame = listOfDicesInGame(lisOfLetters, discardedDice);
        userInterface.listOfKeepDices(dicesInGame);
        return dicesInGame;
    }

    public List<Integer> rollTheRemainingDice(String ktorego, List<Integer> dicesInGame) {

        userInterface.inscriptionRollTheDices(ktorego);
        List<Integer> discardedDice = rollTheDicesModel.nextDiceRoll(dicesInGame);
        userInterface.showRolledDice(discardedDice);
        return discardedDice;
    }

    public List<Integer> keepAndRoll(String ktorego, List<Integer> discardedDice) {

        List<Integer> dicesInGame = generateRollOfDice(discardedDice);
        return rollTheRemainingDice(ktorego, dicesInGame);
    }

    public Categories selectCategories() {

        int categoryNumber = userInterface.chooseTheCategory();
        Map<Integer, Categories> map = userInterface.createMapOfCategories();
        return map.get(categoryNumber);
    }

    public void addPointsToTable(Categories choseCategory, List<Integer> discardedDice3) {

        int points = calculatePoints(choseCategory, discardedDice3);
        current.addResult(choseCategory, points);
        userInterface.gameStatus(player1, player2);
    }

    public boolean endOfGame() {

        if (player1.getResultsSize() == userInterface.createMapOfCategories().size() &&
                player2.getResultsSize() == userInterface.createMapOfCategories().size()) return true;
        return false;
    }
}



