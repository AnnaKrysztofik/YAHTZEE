package main.Points;

import main.Enums.Categories;

import java.util.List;

public class FullCalculateStrategy implements PointsCalculateStrategyInterface {
    @Override
    public boolean canCalculate(Categories category) {
        return category == Categories.FullHouse;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {
        for (int i = 0; i < 6; i++) {

            final int v = i + 1;

            if (dices.stream().filter(d -> d == v).count() == 3) {
                for (int j = 1; j < 7; j++) {
                    int w = j;
                    if (dices.stream().filter(d -> d != v).filter(b -> b == w).count() == 2)

                        return 25;
                }
            }
        }
        return 0;

    }
}


