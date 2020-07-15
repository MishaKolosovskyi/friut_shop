package service.impl;

import model.FruitData;
import model.Type;
import service.FruitService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {

    @Override
    public Map<String, Integer> getFruitAndQuantity(List<FruitData> fruits) {
        Map<String, Integer> map = new HashMap<>();
        for (FruitData fruit : fruits) {
            if (!map.containsKey(fruit.getFruit())) {
                map.put(fruit.getFruit(), fruit.getQuantity());
            } else {
                int value = map.get(fruit.getFruit());
                if (fruit.getType().equals(Type.s)) {
                    value = value + fruit.getQuantity();
                } else {
                    value = value - fruit.getQuantity();
                }
                map.put(fruit.getFruit(), value);
            }
        }
        return map;
    }
}
