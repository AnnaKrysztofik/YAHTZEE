package main.Points;

import main.Enums.Categories;

import java.util.List;

public class ChanceCalculateStrategy implements PointsCalculateStrategyInterface{

    @Override
    public boolean canCalculate(Categories category) {
        return category == Categories.Chance;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {
        return dices.stream().mapToInt(i->i).sum();
    }
}
