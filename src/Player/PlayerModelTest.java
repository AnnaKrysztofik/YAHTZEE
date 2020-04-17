package Player;

import Enums.Categories;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerModelTest {
//    @Test
//    public void czyMoznaDodacDrugiRazKategorie_Test(){
//        // Arrange
//       PlayerModel playerModel = new PlayerModel("Ania");
//
//        // Act
//        playerModel.addResult(Categories.JEDYNKI, 5);
//        playerModel.addResult(Categories.DWOJKI, 12);
//
//
//        boolean result = playerModel.addResult(Categories.JEDYNKI, 10);
//
//        // Assert
//        assertFalse(result);
//    }
//    @Test
//    public void czyMoznaDodacNowaKategoria_Test(){
//        // Arrange
//        PlayerModel playerModel = new PlayerModel("Ania");
//
//        // Act
//        playerModel.addResult(Categories.JEDYNKI, 5);
//        playerModel.addResult(Categories.DWOJKI, 12);
//
//
//        boolean result = playerModel.addResult(Categories.TROJKI, 10);
//
//        // Assert
//        assertTrue(result);
//    }

    @Test
    public void zwracaniWynikuByCategory_Test() {
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");
        playerModel.addResult(Categories.TROJKA,19);
        // Act
        Integer result = playerModel.getPointsByCategory(Categories.TROJKA);

        //Assert
        assertEquals(19,result);

    }
    @Test
    public void zwracaniWynikuByCategoryNull_Test() {
        // Arrange
        PlayerModel playerModel = new PlayerModel("Ania");
        // Act
        Integer result = playerModel.getPointsByCategory(Categories.TROJKA);

        //Assert
        assertNull(result);

    }
}