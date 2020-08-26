package test;
import main.Enums.Categories;
import main.GameManager;
import main.Player.PlayerModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void pointsCounterTest(int expectedResult, Categories category, List<Integer> dices) {
        // Arrange
        GameManager sut = new GameManager();

        // Act
        int result = sut.calculatePoints(category, dices);

        // Assert
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(2, Categories.Aces, List.of(1, 1, 3, 2, 2)),
                Arguments.of(0, Categories.Aces, List.of(2, 3, 3, 2, 2)),
                Arguments.of(5, Categories.Aces, List.of(1, 1, 1, 1, 1)),
                Arguments.of(2, Categories.Twos, List.of(2, 1, 1, 1, 1)),
                Arguments.of(6, Categories.Twos, List.of(2, 1, 1, 2, 2)),
                Arguments.of(0, Categories.Twos, List.of(3, 1, 1, 4, 5)),
                Arguments.of(3, Categories.Threes, List.of(1, 1, 3, 4, 5)),
                Arguments.of(0, Categories.Threes, List.of(1, 2, 6, 4, 5)),
                Arguments.of(15, Categories.Threes, List.of(3, 3, 3, 3, 3)),
                Arguments.of(0, Categories.Threes, List.of(6, 6, 6, 4, 5)),
                Arguments.of(3, Categories.Threes, List.of(3, 1, 2, 4, 5)),
                Arguments.of(20, Categories.ThreeOfAKind, List.of(5, 1, 5, 4, 5)),
                Arguments.of(5, Categories.FourOfAKind, List.of(1, 1, 1, 1, 1)),
                Arguments.of(21, Categories.FourOfAKind, List.of(5, 5, 1, 5, 5)),
                Arguments.of(0, Categories.FourOfAKind, List.of(1, 2, 1, 5, 1)),
                Arguments.of(29, Categories.FourOfAKind, List.of(6, 6, 6, 6, 5)),
                Arguments.of(25, Categories.Fives, List.of(5, 5, 5, 5, 5)),
                Arguments.of(0, Categories.Fives, List.of(1, 1, 2, 2, 2)),
                Arguments.of(0, Categories.Fives, List.of(2, 2, 2, 2, 1)),
                Arguments.of(0, Categories.Fives, List.of(6, 6, 1, 2, 2)),
                Arguments.of(0, Categories.Fives, List.of(6, 6, 1, 3, 2)),
                Arguments.of(40, Categories.LargeStraight, List.of(2, 3, 4, 5, 6)),
                Arguments.of(40, Categories.LargeStraight, List.of(1, 2, 3, 4, 5)),
                Arguments.of(0, Categories.LargeStraight, List.of(1, 2, 3, 4, 4)),
                Arguments.of(0, Categories.LargeStraight, List.of(1, 2, 3, 4, 6)),
                Arguments.of(0, Categories.LargeStraight, List.of(1, 2, 3, 5, 6)),
                Arguments.of(0, Categories.LargeStraight, List.of(1, 4, 3, 5, 6)),
                Arguments.of(30, Categories.SmallStraight, List.of(2, 3, 4, 5, 6)),
                Arguments.of(30, Categories.SmallStraight, List.of(1, 2, 3, 4, 5)),
                Arguments.of(30, Categories.SmallStraight, List.of(3, 4, 5, 2, 2)),
                Arguments.of(0, Categories.SmallStraight, List.of(1, 2, 6, 4, 5)),
                Arguments.of(0, Categories.SmallStraight, List.of(1, 2, 3, 6, 5)),
                Arguments.of(0, Categories.SmallStraight, List.of(1, 2, 2, 4, 4)),
                Arguments.of(30, Categories.SmallStraight, List.of(6, 5, 4, 3, 2)),
                Arguments.of(30, Categories.SmallStraight, List.of(4, 3, 6, 5, 5)),
                Arguments.of(0, Categories.Yahtzee, List.of(4, 3, 6, 5, 5)),
                Arguments.of(50, Categories.Yahtzee, List.of(5, 5, 5, 5, 5)),
                Arguments.of(25, Categories.Chance, List.of(5, 5, 5, 5, 5)),
                Arguments.of(18, Categories.Chance, List.of(1, 2, 4, 5, 6)),
                Arguments.of(21, Categories.ThreeOfAKind, List.of(1, 2, 6, 6, 6)),
                Arguments.of(0, Categories.ThreeOfAKind, List.of(1, 2, 5, 5, 6)),
                Arguments.of(25, Categories.FourOfAKind, List.of(1, 6, 6, 6, 6)),
                Arguments.of(0, Categories.FourOfAKind, List.of(5, 5, 5, 1, 6))
        );
    }

    @Test
    public void listOfDicesInGame_1_Test() {
        // Arrange
        GameManager sut = new GameManager();
        List<String> lisOfLetters = List.of("A", "C", "E");
        List<Integer> discardedDice = List.of(1, 3, 5, 6, 4);

        // Act
        List<Integer> result = sut.listOfDicesInGame(lisOfLetters, discardedDice);

        // Assert
        assertEquals(List.of(1, 5, 4), result);

    }

    @Test
    public void listOfDicesInGame_2_Test() {
        // Arrange
        GameManager sut = new GameManager();
        List<String> lisOfLetters = List.of("D", "C", "E");
        List<Integer> discardedDice = List.of(1, 3, 5, 6, 4);

        // Act
        List<Integer> result = sut.listOfDicesInGame(lisOfLetters, discardedDice);

        // Assert
        assertEquals(List.of(6, 5, 4), result);

    }

    @Test
    public void createListOfLetters_ACD_1_Test() {
        // Arrange
        GameManager sut = new GameManager();

        // Act
        List<String> result = sut.createListOfLetters("A,C,D");

        // Assert
        assertEquals(List.of("A", "C", "D"), result);

    }

    @Test
    public void createListOfLetters_Ace_1_Test() {
        // Arrange
        GameManager sut = new GameManager();

        // Act
        List<String> result = sut.createListOfLetters("A,c,e");

        // Assert
        assertEquals(List.of("A", "C", "E"), result);
    }

    @Test
    public void createListOfLetters_ACD_AB_Test() {
        // Arrange
        GameManager sut = new GameManager();

        // Act
        sut.createListOfLetters("A,c,D");
        List<String> result = sut.createListOfLetters("A,B");

        // Assert
        assertEquals(List.of("A", "B"), result);
    }

    @Test
    public void addPointsToTable() {
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");

        // Act
        playerModel.addResult(Categories.Aces, 5);
        playerModel.addResult(Categories.Twos, 4);

        // Assert
        assertEquals(9, playerModel.getSumOfPoints());
    }
}