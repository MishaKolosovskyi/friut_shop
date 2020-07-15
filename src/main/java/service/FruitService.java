package service;

import model.FruitData;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> getFruitAndQuantity(List<FruitData> fruits);
}
