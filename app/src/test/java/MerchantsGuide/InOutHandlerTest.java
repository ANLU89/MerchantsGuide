package MerchantsGuide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InOutHandlerTest {

    InOutHandler inOut = new InOutHandler();

    @Test 
    void mapGlobToI() throws Exception {
        assertEquals(null, inOut.handleLine("glob is I"));
    }
    @Test 
    void mapProkToV() throws Exception {
        assertEquals(null, inOut.handleLine("prok is V"));
    }
    @Test 
    void map4Silverto100Credits() throws Exception {
        inOut.handleLine("glob is I");
        inOut.handleLine("prok is V");
        assertEquals(null, inOut.handleLine("glob prok Silver is 100 Credits"));
    }
    @Test 
    void answerHowManyCredits2SilverIs() throws Exception {
        inOut.handleLine("glob is I");
        inOut.handleLine("prok is V");
        inOut.handleLine("glob prok Silver is 100 Credits");
        assertEquals("glob glob Silver is 50 Credits", inOut.handleLine("how many Credits is glob glob Silver ?"));
    }
    @Test 
    void answerHowMuchProkGlobIs() throws Exception {
        inOut.handleLine("glob is I");
        inOut.handleLine("prok is V");
        assertEquals("prok glob is 6", inOut.handleLine("how much is prok glob ?"));
    }
    @Test 
    void noIdea() throws Exception {
        assertEquals("I have no idea what you are talking about", inOut.handleLine("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));

    }
    @Test 
    void answerFirstQuestion() throws Exception {
        inOut.handleLine("glob is I");
        inOut.handleLine("prok is V");
        inOut.handleLine("pish is X");
        inOut.handleLine("tegj is L");
        assertEquals("pish tegj glob glob is 42", inOut.handleLine("how much is pish tegj glob glob ?"));
    }
    @Test 
    void answerSecondQuestion() throws Exception {
        inOut.handleLine("glob is I");
        inOut.handleLine("prok is V");
        inOut.handleLine("pish is X");
        inOut.handleLine("tegj is L");
        inOut.handleLine("glob glob Silver is 34 Credits");
        assertEquals("glob prok Silver is 68 Credits", inOut.handleLine("how many Credits is glob prok Silver ?"));
    }   

}
