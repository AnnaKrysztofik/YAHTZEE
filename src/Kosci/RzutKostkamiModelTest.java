package Kosci;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RzutKostkamiModelTest {

    @Test
    public void kolejnyRzutKostkamiZatrzymano5kostek(){
        // Arrange
        RzutKostkamiModel sut = new RzutKostkamiModel();

        // Act
        List<Integer> result = sut.kolejnyRzutKostkami(List.of(1,3,5,2,3));

        // Assert
        assertEquals(List.of(1,3,5,2,3), result);
    }
    @Test
    public void kolejnyRzutKostkamiZatrzymano1kostkee(){
        // Arrange
        RzutKostkamiModel sut = new RzutKostkamiModel();

        // Act
        List<Integer> result = sut.kolejnyRzutKostkami(List.of(6));

        // Assert
        assertEquals(5, result.size());
    }
}