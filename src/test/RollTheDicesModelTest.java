package test;

import main.dices.RollTheDicesModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RollTheDicesModelModelTest {

    @Test
    public void nextDiceRollKeepFiveDices(){
        // Arrange
        RollTheDicesModel sut = new RollTheDicesModel();

        // Act
        List<Integer> result = sut.nextDiceRoll(List.of(1,3,5,2,3));

        // Assert
        assertEquals(List.of(1,3,5,2,3), result);
    }
    @Test
    public void nextDiceRollKeepOneDice(){
        // Arrange
        RollTheDicesModel sut = new RollTheDicesModel();

        // Act
        List<Integer> result = sut.nextDiceRoll(List.of(6));

        // Assert
        assertEquals(5, result.size());
    }
}