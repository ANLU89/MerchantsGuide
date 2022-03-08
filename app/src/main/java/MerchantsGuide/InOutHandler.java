package MerchantsGuide;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles the input either passed as a textfile or by single line input.
 */


public class InOutHandler {

    private static HashMap<String, Integer> valuePerUnitMap = new HashMap<String, Integer>();
    private static HashMap<String, Character> romanSymbolMap = new HashMap<String, Character>();
    private static String ERROR = "I have no idea what you are talking about";
    
    public InOutHandler(){

    }

    public void handleFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null)
            {
                handleLine(line);
            }

        } catch (IOException e) {
            System.out.println("File not found! " + e);
        } 
    }

    public void handleLine(String line){
        String out = processLine(line);
        if (out != null) System.out.println(out);
    }

    public String processLine(String line){
        String trimLine = line.trim();
        String[] words = trimLine.split("\\s+");
        if(trimLine.endsWith("?")){
            if(trimLine.startsWith("how much is")){
                return answerQuestion(words, false);
            }
            else if (trimLine.startsWith("how many Credits is")){
                return answerQuestion(words, true);
            }
        }
        else if (trimLine.contains("is")){
            if (trimLine.contains("Credits")){
                return mapUnitToValue(words);
            }
            else {
                return mapWordToSymbol(words);
            }
        }
        return ERROR;
    }

    private String convertWordsToNumeral(ArrayList<String> words){
        String numeral = "";
        for (String word : words){
            if (!romanSymbolMap.containsKey(word)) return null;
            numeral += romanSymbolMap.get(word);
        }
        return numeral;
    }

    private String answerQuestion(String[] words, boolean credits){
        RomanToDecConverter converter = new RomanToDecConverter();
        String numeral, unit;
        int value, trim = 0;
        String out = "";

        if (credits) trim = 1;
        ArrayList<String> wordsToBeConverted = new ArrayList<String>();
        for (int i = 3 + trim; i < words.length - 1 - trim; i++){
            wordsToBeConverted.add(words[i]);
            out += words[i] + " ";
        }
        
        numeral = convertWordsToNumeral(wordsToBeConverted);
        if (numeral == null) return ERROR;
        try {
            value = converter.calculateDecValue(numeral);
        }
        catch(Exception e){
            return ERROR;
        }

        if (credits){
            unit = words[words.length - 2];
            if (!valuePerUnitMap.containsKey(unit)) return ERROR;
            value *= valuePerUnitMap.get(unit);
            out += unit + " is " + value + " Credits";
        }
        else out += "is " + value;
        return out;
    }

    private String mapWordToSymbol(String[] words){
        if (words.length != 3) return ERROR;
        RomanToDecConverter converter = new RomanToDecConverter();
        String word = words[0];
        char symbol = words[2].charAt(0);
        if (!converter.isValidCharacter(symbol)) return ERROR;
        romanSymbolMap.put(word, symbol);
        return null;
    }

    private String mapUnitToValue(String[] words){
        RomanToDecConverter converter = new RomanToDecConverter();
        ArrayList<String> wordsToBeConverted = new ArrayList<String>();
        String word = words[words.length - 4];
        String numeral;
        int amount, value;

        for (int i = 0; i < words.length - 4; i++){
            wordsToBeConverted.add(words[i]);
        }
        numeral = convertWordsToNumeral(wordsToBeConverted);
        try{
            amount = converter.calculateDecValue(numeral);
            value = Integer.parseInt(words[words.length - 2]);
        }
        catch(Exception e){
            return ERROR;
        }
        valuePerUnitMap.put(word, (value / amount));
        return null;
    }
}
