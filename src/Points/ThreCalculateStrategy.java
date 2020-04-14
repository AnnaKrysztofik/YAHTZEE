package Points;

import Enums.Categories;

import java.util.List;

public class ThreCalculateStrategy implements PointsCalculateStrategyInterface {

    @Override
    public boolean canCalculate(Categories category) {

        return category == Categories.TROJKA;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {

        for (int i = 0; i < 6; i++) {

            final int v = i+1;

            if (dices.stream().filter(d -> d == v).count() >= 3)
                return dices.stream().mapToInt(d -> d).sum();
        }

        return 0;
    }
}
