package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String checkLetter(String input) throws IOException {
        while (!(input.equals("r") || input.equals("b") || input.equals("s"))){
            input = getDataFromConsole();
        }
        return input;
    }

    public String getDataFromConsole() throws IOException {
        String output = reader.readLine();
        while (output.isEmpty()) {
            output = reader.readLine();
        }
        return output;
    }

    public String checkString(String input) throws IOException {
        while (input.isEmpty()){
            input = getDataFromConsole();
        }
        return input;
    }

    public String checkQuantity(String input) throws IOException {
        boolean isInputInteger = false;
        while (!isInputInteger) {
            try {
                Integer.parseInt(input);
                isInputInteger = true;
            } catch (NumberFormatException e) {
                input = getDataFromConsole();
            }
        }
        return input;
    }
}
