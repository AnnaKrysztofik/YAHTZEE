package main.Points;

import main.Enums.Categories;

import java.util.List;
import java.util.Map;

public class SinglesCalculateStrategy implements PointsCalculateStrategyInterface{

    private List<Categories> categories = List.of(Categories.Aces,
            Categories.Twos, Categories.Threes, Categories.Fours, Categories.Fives, Categories.Sixes);

    private Map<Categories, Integer> categoryMapper = Map.of(
            Categories.Aces,1,
            Categories.Twos, 2,
            Categories.Threes, 3,
            Categories.Fours,4,
            Categories.Fives, 5,
            Categories.Sixes, 6);

    @Override
    public boolean canCalculate(Categories category) {

        return categories.contains(category);
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {

        return categoryMapper.get(category) * (int) dices.stream()
                .filter(i -> i.equals(categoryMapper.get(category)))
                .count();
    }
}
