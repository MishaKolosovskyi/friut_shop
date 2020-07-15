package service;

import model.FruitData;
import java.util.List;

public interface FileService {
    void writeToFile(String path, boolean append, Object... parameters);
    List<FruitData> readFile(String path);
}
