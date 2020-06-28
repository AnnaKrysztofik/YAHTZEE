package main.Points;

import main.Enums.Categories;

import java.util.List;

public class LargeStraightCalculateStrategy implements PointsCalculateStrategyInterface {
    @Override
    public boolean canCalculate(Categories category) {
        return category == Categories.LargeStraight;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {
        if (dices.stream().distinct().count() != 5) return 0;
        int sum = dices.stream().mapToInt(i -> i).sum();
        if (sum == 20 || sum == 15) return 40;
        return 0;
    }
}
