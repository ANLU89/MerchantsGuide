package MerchantsGuide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RomanToDecConverter {
    /**
     * This class is supposed to validate and calculate the value of roman numerals.
     * @return
     */
    


    private static HashMap<Character, Integer> symbols(){

        /**
         * Binds the Roman numerals to their values
         */


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


    private static HashMap<Character, HashSet<Character>> validSubtractions(){

        /**
         * Defines the permitted subtractions when calculating the value of a given numeral.
         */

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


    private static HashSet<Character> validRepeats(){

        /**
         * Defines which symbols may be repeated in a numeral
         */

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

    public static int calculateDecValue(String numeral) throws Exception{

        /**
         * Calculates the decimal value of a given numeral or throws an exception if given numeral is invalid.
         */

        ArrayList<Character> chars = new ArrayList<Character>();
        
        for (char c : numeral.toCharArray()){
            if (isValidCharacter(c)) chars.add(c);
            else throw new Exception("invalid character!");
        }
        if (chars.size() == 0) return 0;
        char first = chars.get(0), second;                                  // these store the first two characters of the numeral
        int firstVal, secondVal;                                            // here the decimal values of the first two characters are stored for comparisons
        boolean repeats = false;                                            // keeps track of the repitition of symbols
        int sum = 0;                                                        // stores the current result of the calculation and is returned in the end
        int lastSub = Integer.MAX_VALUE;                                    // stores the last used subtrahend
        int lastVal = Integer.MAX_VALUE;                                    // stores the last added value except subtractions 
        while (chars.size() >= 1){
            first = chars.get(0);
            firstVal = symbols().get(first);
            if (firstVal >= lastSub || firstVal > lastVal) throw new Exception("invalid numeral!");
            else {
                if (chars.size() == 1) {
                    sum += firstVal;
                    break;
                } 
                second = chars.get(1);
                secondVal = symbols().get(second);
                if (secondVal == firstVal){
                    if (!isValidRepeat(first)) throw new Exception(first + " may not be repeated!");
                    else {
                        lastVal = firstVal;
                        sum += (2 * firstVal);
                        if (repeats) throw new Exception("too many repititions of " + first + "!");
                        else {
                            repeats = true;
                            chars.remove(0);
                        }
                    }
                }
                else {
                    repeats = false;
                    if (firstVal < secondVal) {
                        if (!isValidSubtraction(first, second)) throw new Exception(first + " may not be subtracted from " + second + "!");
                        else if (secondVal > lastVal) throw new Exception("invalid numeral! " + secondVal + " is greater than " + firstVal + "!");
                        else {
                            lastSub = firstVal;
                            sum += (secondVal - firstVal);
                            chars.remove(0);
                        }
                    }
                    else {
                        lastVal = firstVal;
                        sum += firstVal;
                    }
                }
                chars.remove(0);
            }
        }
        return sum;
    }
}