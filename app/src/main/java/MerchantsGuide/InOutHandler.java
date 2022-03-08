package MerchantsGuide;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class processes the input either passed as a textfile or by single line input and prints the results.
 */


public class InOutHandler {

    private static HashMap<String, Integer> valuePerUnitMap = new HashMap<String, Integer>();
    private static HashMap<String, Character> romanSymbolMap = new HashMap<String, Character>();
    private static String ERROR = "I have no idea what you are talking about";
    
    public InOutHandler(){

    }

    /**
     * gets passed a file path and passes each single line to the handleLine method
     * @param file
     */
    public void handleFile(String file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null)
            {
                handleLine(line);
            }
        } catch (IOException e) {
            System.out.println("File not found! " + e);
        } 
    }

    /**
     * gets passed a single line command, passes it to the processLine method and prints the result
     * @param line
     */
    public void handleLine(String line){
        String out = processLine(line);
        if (out != null) System.out.println(out);
    }

    /**
     * gets passed a single line, determines which type of command it is and calls the associated method
     * @param line
     * @return
     */
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

    /**
     * converts a sequence of intergalactic words to the corresponding roman numeral
     * @param words
     * @return
     */
    private String convertWordsToNumeral(ArrayList<String> words){
        String numeral = "";
        for (String word : words){
            if (!romanSymbolMap.containsKey(word)) return null;
            numeral += romanSymbolMap.get(word);
        }
        return numeral;
    }

    /**
     * either calculates the decimal representation of a sequence of intergalactic words
     * or the value in Credits of a material unit where the amount is given by a sequence of intergalactic words
     * @param words
     * @param credits
     * @return
     */
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

    /**
     * maps a intergalactic word to a roman symbol
     * @param words
     * @return
     */
    private String mapWordToSymbol(String[] words){
        if (words.length != 3) return ERROR;
        RomanToDecConverter converter = new RomanToDecConverter();
        String word = words[0];
        char symbol = words[2].charAt(0);
        if (!converter.isValidCharacter(symbol)) return ERROR;
        romanSymbolMap.put(word, symbol);
        return null;
    }

    /**
     * maps a material unit to it's per-unit value
     * @param words
     * @return
     */
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
