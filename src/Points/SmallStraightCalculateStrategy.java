package Points;

import Enums.Categories;

import java.util.List;
import java.util.stream.Collectors;

public class SmallStraightCalculateStrategy implements PointsCalculateStrategyInterface {
    @Override
    public boolean canCalculate(Categories category) {
        return category == Categories.MALY_STRIT;
    }

    @Override
    public int calculate(Categories category, List<Integer> dices) {

            List<Integer> dicesSorted = dices.stream().sorted().collect(Collectors.toList());

            for (int i = 0; i < 4; i++) {
                if (dicesSorted.get(i + 1) != dicesSorted.get(i) + 1) return 0;
            }
            return 30;


    }
}

