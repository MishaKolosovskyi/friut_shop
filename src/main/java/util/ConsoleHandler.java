package util;

import model.FruitData;
import service.FruitService;
import service.impl.FileServiceImpl;
import service.impl.FruitServiceImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import static service.impl.FileServiceImpl.*;

public class ConsoleHandler {

    public static final String FILE_EXTENSION = ".csv";
    private static FileServiceImpl fileService = new FileServiceImpl();
    private static Validator validator = new Validator();
    private static FruitService fruitService = new FruitServiceImpl();

    public void run() {
        try {
            System.out.println("Enter the input file name ");
            String inputFileName = validator.getDataFromConsole() + FILE_EXTENSION;
            createFileIfItDoesNotExists(inputFileName, true, TYPE, FRUIT_NAME, QUANTITY,
                    DATE);
            System.out.println("Enter the output file name ");
            String outputFileName = validator.getDataFromConsole() + FILE_EXTENSION;
            createFileIfItDoesNotExists(outputFileName, false, FRUIT_NAME, QUANTITY);
            fileService.writeToFile(inputFileName, true, getDataFromUser());
            List<FruitData> fruitData = fileService.readFile(inputFileName);
            Map<String, Integer> fruitAndQuantity = fruitService.getFruitAndQuantity(fruitData);
            boolean append = false;
            for (Map.Entry<String, Integer> entry : fruitAndQuantity.entrySet()) {
                fileService.writeToFile("output.csv", append, entry.getKey(),
                        entry.getValue());
                append = true;
            }
        }catch (IOException e){
            System.err.format("IOException: %s%n", e);
        }
    }

    private String[] getDataFromUser() {
        String type = "";
        String fruitName = "";
        String quantity = "";
        String date = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Press key: \n" +
                    "s - supply, means you are receiving fruits from suppliers \n" +
                    "b - buy, means someone bought a fruit \n" +
                    "r - return, means someone who have bought fruits now returns it to you");
            type = validator.checkLetter(validator.getDataFromConsole());
            System.out.println("Enter a fruit name:");
            fruitName = validator.checkString(validator.getDataFromConsole());
            System.out.println("Enter a quantity:");
            quantity = validator.checkQuantity(validator.getDataFromConsole());
            System.out.println("Enter a date");
            date = reader.readLine();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return new String[]{type, fruitName, quantity, date};
    }

    private void createFileIfItDoesNotExists(String fileName, boolean append, String... parameters)
    {
        if (!new File(fileName).exists()) {
            fileService.writeToFile(fileName, append, parameters);
        }
    }
}
