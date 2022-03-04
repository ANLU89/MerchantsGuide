package MerchantsGuide;

import java.util.HashMap;
import java.util.HashSet;

public class RomanToDecConverter {
    /**
     * This class is supposed to validate and calculate the value of roman numerals.
     * @return
     */
    

    // Binds the Roman numerals to their values
    private static HashMap<Character, Integer> symbols(){
        HashMap<Character, Integer> symbolsMap = new HashMap<Character, Integer>();
            symbolsMap.put('I', 1);
            symbolsMap.put('V', 5);
            symbolsMap.put('X', 10);
            symbolsMap.put('L', 50);
            symbolsMap.put('C', 100);
            symbolsMap.put('D', 500);
            symbolsMap.put('M', 1000);
        return symbolsMap;
    }

    // Defines the permitted subtractions when calculating the value of a given numeral.
    private static HashMap<Character, HashSet<Character>> validSubtractions(){

        HashMap<Character, HashSet<Character>> vSubs = new HashMap<Character, HashSet<Character>>();

        HashSet<Character> s = new HashSet<Character>();
        s.add('V');
        s.add('X');
        vSubs.put('I', s);

        s = new HashSet<Character>();
        s.add('L');
        s.add('C');
        vSubs.put('X', s);

        s = new HashSet<Character>();
        s.add('D');
        s.add('M');
        vSubs.put('C', s);

        return vSubs;
    }

    // Defines which symbols may be repeated in a numeral
    private static HashSet<Character> validRepeats(){
        HashSet<Character> r = new HashSet<Character>();
        r.add('I');
        r.add('X');
        r.add('C');
        r.add('M');
        return r;
    }


    public static boolean isValidCharacter(char c){
        return symbols().containsKey(c);
    }

    public static boolean isValidSubtraction(char first, char second){
        return validSubtractions().get(first).contains(second);
    }

    public static boolean isValidRepeat(char c){
        return validRepeats().contains(c);
    }


}