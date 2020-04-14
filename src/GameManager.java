import Enums.Categories;
import Kosci.RzutKostkamiModel;
import Player.PlayerModel;
import Points.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameManager {

    private PlayerModel player1;
    private PlayerModel player2;
    private PlayerModel current;
    UserInterface userInterface = new UserInterface();
    RzutKostkamiModel rzutKostkamiModel;
   private  List<Integer> dicesInGame;

    //main.GameManager gameManager;

    List<PointsCalculateStrategyInterface> pointsCounterStrategies = List.of(
            new SinglesCalculateStrategy(),
            new ThreCalculateStrategy(),
            new FourCalculateStrategy(),
            new FullCalculateStrategy(),
            new SmallStraightCalculateStrategy(),
            new LargeStraightCalculateStrategy(),
            new YahtzeeCalculateStrategy(),
            new ChanceCalculateStrategy()
    );


    List<Integer> dieces;

    public GameManager() {

        player1 = new PlayerModel("Ania");
        player2 = new PlayerModel("Jacek");
        current = player1;
        rzutKostkamiModel = new RzutKostkamiModel();
        dicesInGame = new ArrayList<>();


        //  player1.addResult(Categories.DWOJKI, 11);
        //  player2.addResult(Categories.DWOJKI, 22);
    }

    private void nextPlayer() {
        if (current == player1)
            current = player2;
        else current = player1;
    }

    public void courseOfGame() {
        userInterface.welcomeScreen();
        userInterface.wyswietlTabliceZeStanemGry(player1, player2);
        do {
            userInterface.displayPlayer(current);


                                                                             //   generateRollOfDice();

            userInterface.inscriptionRollTheDices("pierwszego");
            List<Integer> discardedDice = rzutKostkamiModel.rzutPieciomaKostkami();
             userInterface.wyswietlRzutKostka(discardedDice);

                                                                                 //  rollTheRemainingDice("pierwszego");

                String letters = userInterface.inscriptionChooseDices();
                List<String> lisOfLetters = createListOfLetters(letters);
                dicesInGame  = listOfDicesInGame(lisOfLetters, discardedDice);
                userInterface.listOfKeepDices(dicesInGame);


                //drugi rzut
            userInterface.inscriptionRollTheDices("drugiego");
            List<Integer> discardedDice2 = rzutKostkamiModel.kolejnyRzutKostkami(dicesInGame);
              userInterface.wyswietlRzutKostka(discardedDice2);



                String letters2 = userInterface.inscriptionChooseDices();
                List<String> lisOfLetters2 = createListOfLetters(letters2);
                dicesInGame  = listOfDicesInGame(lisOfLetters2, discardedDice2);
                userInterface.listOfKeepDices(dicesInGame);


                //trzeci rzut
            userInterface.inscriptionRollTheDices("trzeciego");
            List<Integer> discardedDice3 = rzutKostkamiModel.kolejnyRzutKostkami(dicesInGame);
            userInterface.wyswietlRzutKostka(discardedDice3);



        } while (false);
    }


    public int calculatePoints(Categories category, List<Integer> dices) {
        return pointsCounterStrategies.stream()
                .filter(s -> s.canCalculate(category))
                .mapToInt(s -> s.calculate(category, dices))
                .sum();
    }


    public List<Integer> listOfDicesInGame ( List<String> lisOfLetters, List<Integer> discardedDice) {

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
        } return myList;
    }

    public List<String> createListOfLetters(String letters){
        String[] letter = letters.split(",", 5);
      return  Stream.of(letter).map(s->s.toUpperCase()).collect(Collectors.toList());
    }



//    public List<Integer> generateRollOfDice()
//    {
//
//    }


//    public void rollTheRemainingDice()
//    {
//
//    }
}


