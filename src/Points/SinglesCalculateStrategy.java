package Points;

import Enums.Categories;

import java.util.List;
import java.util.Map;

public class SinglesCalculateStrategy implements PointsCalculateStrategyInterface{

    private List<Categories> categories = List.of(Categories.JEDYNKI,
            Categories.DWOJKI, Categories.TROJKI, Categories.CZWORKI, Categories.PIATKI, Categories.SZOSTKI);

    private Map<Categories, Integer> categoryMapper = Map.of(
            Categories.JEDYNKI,1,
            Categories.DWOJKI, 2,
            Categories.TROJKI, 3,
            Categories.CZWORKI,4,
            Categories.PIATKI, 5,
            Categories.SZOSTKI, 6);

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
