package service.impl;

import model.FruitData;
import model.Type;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import service.FileService;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    public static final String TYPE = "type";
    public static final String FRUIT_NAME = "fruit";
    public static final String QUANTITY = "quantity";
    public static final String DATE = "date";

    public void writeToFile(String path, boolean append,  Object... parameters) {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(path, append), CSVFormat.DEFAULT)) {
            if (!append){
                printer.printRecord("fruit", "quantity");
            }
            printer.printRecord(parameters);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    @Override
    public List<FruitData> readFile(String path) {
        List<FruitData> fruits = new ArrayList<>();
        try (Reader file = new FileReader(path)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(file);
            for (CSVRecord record : records) {
                String type = record.get(TYPE);
                String name = record.get(FRUIT_NAME);
                int quantity = Integer.parseInt(record.get(QUANTITY));
                String date = record.get(DATE);
                fruits.add(new FruitData(Type.valueOf(type), name, quantity, date));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return fruits;
    }
}
