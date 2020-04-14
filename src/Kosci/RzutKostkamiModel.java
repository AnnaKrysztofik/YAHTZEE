package Kosci;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RzutKostkamiModel {



    public RzutKostkamiModel(){
    }


public Integer generujRzutJednaKostka(){
 Random random = new Random();
 return random.nextInt(6)+1;
 }

 public List<Integer> rzutPieciomaKostkami(){
      return  List.of(generujRzutJednaKostka(), generujRzutJednaKostka(), generujRzutJednaKostka(),
              generujRzutJednaKostka(), generujRzutJednaKostka());

 }

    public List<Integer> kolejnyRzutKostkami(List<Integer> dicesInGame) {

        List<Integer> secondTimesThrowTheDice = new ArrayList<>();
        for (int i=0; i<dicesInGame.size(); i++)
        {
            secondTimesThrowTheDice.add(dicesInGame.get(i));
        }
        for (int i=dicesInGame.size(); i<5; i++)
        {
            secondTimesThrowTheDice.add(generujRzutJednaKostka());
        }

        return secondTimesThrowTheDice;
    }
    public List<Integer> wyczyscListeDicesInGame(List<Integer> dicesInGame){
        return List.of();
    }

}






