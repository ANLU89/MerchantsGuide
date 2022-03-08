package MerchantsGuide;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InOutHandler {

    private static HashMap<String, Double> valuePerUnitMap = new HashMap<String, Double>();
    private static HashMap<String, Character> romanSymbolMap = new HashMap<String, Character>();
    private static String ERROR = "I have no idea what you are talking about";
    
    public InOutHandler(){

    }

    public void read(String fileName) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String out;
            while((line = br.readLine()) != null)
            {
                out = handleLine(line.trim());
                if (out != null) System.out.println(out);
            }

        } catch (IOException e) {
            System.out.println("File not found! " + e);
        } 
    }

    public String handleLine(String line) throws Exception{
        String[] words = line.split("\\s+");
        if(line.startsWith("how much is")){
            return answerQuestion(words, false);
        }
        else if (line.startsWith("how many Credits is")){
            return answerQuestion(words, true);
        }
        else if (line.contains("is")){

            if (line.contains("Credits")){
                mapUnitToValue(words);
            }
            else {
                if (words.length != 3) return ERROR;
                mapWordToSymbol(words);
            }
            return null;
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

    private String answerQuestion(String[] words, boolean credits) throws Exception{
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
        value = converter.calculateDecValue(numeral);

        if (credits){
            unit = words[words.length - 2];
            if (!valuePerUnitMap.containsKey(unit)) return ERROR;
            value *= valuePerUnitMap.get(unit);
            out += unit + " is " + value + " Credits";
        }
        else out += "is " + value;
        return out;
    }

    private void mapWordToSymbol(String[] words){
        String word = words[0];
        char symbol = words[2].charAt(0);
        romanSymbolMap.put(word, symbol);
        
    }

    private void mapUnitToValue(String[] words) throws Exception{
        RomanToDecConverter converter = new RomanToDecConverter();
        ArrayList<String> wordsToBeConverted = new ArrayList<String>();
        String word = words[words.length - 4];
        String numeral;
        int amount;
        // @TODO exception handling fürs parsing
        double value = Double.parseDouble(words[words.length - 2]);
        for (int i = 0; i < words.length - 4; i++){
            wordsToBeConverted.add(words[i]);
        }
        numeral = convertWordsToNumeral(wordsToBeConverted);
        amount = converter.calculateDecValue(numeral);
        valuePerUnitMap.put(word, value / amount);

    }
}
