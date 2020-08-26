package test;

import main.Enums.Categories;
import main.Player.PlayerModel;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerModelTest {
    @Test
    public void playerHasAlreadySelectedACategory(){
        // Arrange
       PlayerModel playerModel = new PlayerModel("Ania");

        // Act
        Map<Categories, Integer> results = new HashMap<>();
        results.put(Categories.Twos,10);
        boolean result = playerModel.containsCategory(Categories.Twos);

        // Assert
        assertTrue(result);
    }

     @Test
    public void playerChoosesTheCategoryForTheFirstTime(){
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");

        // Act
        Map<Categories, Integer> results2 = new HashMap<>();
        results2.put(Categories.Twos,10);
        boolean result2 = playerModel.containsCategory(Categories.Aces);

        // Assert
         assertTrue(result2);
}

    @Test
    public void getPointsByCategory_Test() {
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");
        playerModel.addResult(Categories.Threes,19);

        // Act
        Integer result = playerModel.getPointsByCategory(Categories.Threes);

        //Assert
        assertEquals(19,result);

    }
    @Test
    public void getPointsByCategoryNull_Test() {
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");

        // Act
        Integer result = playerModel.getPointsByCategory(Categories.Threes);

        //Assert
        assertNull(result);
    }
}