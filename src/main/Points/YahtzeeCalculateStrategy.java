package main.Points;

import main.Enums.Categories;

import java.util.List;

public class YahtzeeCalculateStrategy implements PointsCalculateStrategyInterface{
    @Override
    public boolean canCalculate(Categories category) {
        return category == Categories.Yahtzee;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {
         if (dices.stream().distinct().count() == 1) return 50;
         return 0;
    }
}
