package MerchantsGuide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InOutHandlerTest {

    InOutHandler inOut = new InOutHandler();

    @Test 
    void map4Silverto100Credits(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        assertEquals(null, inOut.processLine("glob prok Silver is 100 Credits"));
    }
    @Test 
    void answerHowManyCredits2SilverIs(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        inOut.processLine("glob prok Silver is 100 Credits");
        assertEquals("glob glob Silver is 50 Credits", inOut.processLine("how many Credits is glob glob Silver ?"));
    }
    @Test 
    void answerHowMuchProkGlobIs(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        assertEquals("prok glob is 6", inOut.processLine("how much is prok glob ?"));
    }
    @Test 
    void noIdea(){
        assertEquals("I have no idea what you are talking about", inOut.processLine("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
    @Test 
    void invalidSymbolG(){
        assertEquals("I have no idea what you are talking about", inOut.processLine("glob is G"));
    }
    @Test 
    void askingforValueOfInvalidWordPlok(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        assertEquals("I have no idea what you are talking about", inOut.processLine("how much is plok ?"));
    }
    @Test 
    void answerHowMuchQuestion(){
        inOut.processLine("glob is I");
        inOut.processLine("pish is X");
        inOut.processLine("tegj is L");
        assertEquals("pish tegj glob glob is 42", inOut.processLine("how much is pish tegj glob glob ?"));
    }
    @Test 
    void answerHowManyQuestion(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        inOut.processLine("glob glob Silver is 34 Credits");
        assertEquals("glob prok Silver is 68 Credits", inOut.processLine("how many Credits is glob prok Silver ?"));
    }
    @Test 
    void noQuestionMark(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        inOut.processLine("glob glob Silver is 34 Credits");
        assertEquals("I have no idea what you are talking about", inOut.processLine("how many Credits is glob prok Silver"));
    }
    @Test 
    void singleWrongInput(){
        assertEquals("I have no idea what you are talking about", inOut.processLine("X"));
    }
    @Test 
    void longerWrongInput(){
        assertEquals("I have no idea what you are talking about", inOut.processLine("X X X"));
    }
    @Test 
    void longerWrongInputWithIs(){
        assertEquals("I have no idea what you are talking about", inOut.processLine("X is X X"));
    }
    @Test 
    void waskingforValueOfInvalidMaterialGold(){
        inOut.processLine("glob is I");
        inOut.processLine("prok is V");
        inOut.processLine("glob glob Silver is 34 Credits");
        assertEquals("I have no idea what you are talking about", inOut.processLine("how many Credits is glob prok Gold ?"));
    }
}
