import Enums.Categories;
import Player.PlayerModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class UserInterface {


    private static final List<Categories> listaKategorii = List.of(Categories.JEDYNKI, Categories.DWOJKI, Categories.TROJKI,
            Categories.CZWORKI, Categories.PIATKI, Categories.SZOSTKI, Categories.TROJKA, Categories.CZWORKA, Categories.FULL,
            Categories.MALY_STRIT, Categories.DUZY_STRIT, Categories.GENERAL, Categories.SZANSA);



    public UserInterface(){

}


    public static void welcomeScreen() {
        System.out.println("____YAHTZEE____");
    }




    public void wyswietlTabliceZeStanemGry(PlayerModel player1, PlayerModel player2) {
        System.out.println(player1.getName() + "   " + player2.getName());

        listaKategorii.stream()
                .forEach(c ->
                        System.out.println(" " + (player1.getPointsByCategory(c) == null ? "  " : player1.getPointsByCategory(c)) + "" +
                        "     " + (player2.getPointsByCategory(c) == null ? "  " : player2.getPointsByCategory(c)) + "    " +
                                (c.ordinal()+1) + " " + c.toString())

                );

        System.out.println(" " + player1.getSumaPunktow() + "    " + player2.getSumaPunktow());
    }

    public void displayPlayer(PlayerModel player) {
        System.out.println("Ruch gracza: " + player.getName());
    }

    public static void inscriptionRollTheDices(String ktorego) {
        System.out.println("Wynik " + ktorego + " rzutu: ");
    }


    public static void wyswietlRzutKostka(List<Integer> wylosowaneKosci) {
        System.out.println(wylosowaneKosci.toString());
    }

    public static String inscriptionChooseDices() {
        System.out.println("[A, B, C, D, E] ");
        System.out.println("Które kostki zostają w grze? Wpisz odpowiednie litery oddzielając je przecinkiem, bez spacji");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();

    }


    public static void listOfKeepDices(List<Integer> listOfDicesInGame) {
        System.out.println(listOfDicesInGame.toString());
    }


    public static int chooseTheCategory() {
        System.out.println("Wybierz kategorię, dla której będzie liczony rzut. Wpisz liczbę od 1 do 13: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Map<Integer,Categories> createMapOfCategories() {
        Map<Integer,Categories> mapOfcategories = new HashMap<Integer,Categories>();
        for (int i=0;i<listaKategorii.size(); i++) {
            mapOfcategories.put(i+1, listaKategorii.get(i));
        }
        return mapOfcategories;
    }

    public void categoryIsTaken(){
        System.out.println("Kategoria jest już zajęta. Wybierz inną. ");
    }
}


