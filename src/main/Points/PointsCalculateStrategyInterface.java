package main.Points;

import main.Enums.Categories;

import java.util.List;

public interface PointsCalculateStrategyInterface {

    boolean canCalculate(Categories category);
    int calculate(Categories category, List<Integer> dices);
}
