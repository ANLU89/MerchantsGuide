package MerchantsGuide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanToDecConverterTest {
    @Test 
    void invalidRepeatofV() {
        assertFalse(RomanToDecConverter.isValidRepeat('V'));
    }
    @Test 
    void validRepeatofC() {
        assertTrue(RomanToDecConverter.isValidRepeat('C'));
    }
    @Test 
    void invalidCharacterlH() {
        assertFalse(RomanToDecConverter.isValidCharacter('H'));
    }
    @Test
    void validCharacterX() {
        assertTrue(RomanToDecConverter.isValidCharacter('X'));
    }
    @Test
    void validNumeralIV() throws Exception {
        assertEquals(4, RomanToDecConverter.calculateDecValue("IV"));
    }
    @Test
    void validNumeralMIX() throws Exception {
        assertEquals(1009, RomanToDecConverter.calculateDecValue("MIX"));
    }
    @Test
    void validNumeralMMM() throws Exception {
        assertEquals(3000, RomanToDecConverter.calculateDecValue("MMM"));
    }
    @Test
    void validNumeralCM() throws Exception {
        assertEquals(900, RomanToDecConverter.calculateDecValue("CM"));
    }
    @Test
    void validNumeralMCM() throws Exception {
        assertEquals(1900, RomanToDecConverter.calculateDecValue("MCM"));
    }
    @Test
    void validNumeralMCMXLIV() throws Exception {
        assertEquals(1944, RomanToDecConverter.calculateDecValue("MCMXLIV"));
    }
    @Test
    void validNumeralMMMCMXLIV() throws Exception {
        assertEquals(3944, RomanToDecConverter.calculateDecValue("MMMCMXLIV"));
    }
    @Test
    void invalidNumeralMCMCM() throws Exception {
        assertEquals(-1, RomanToDecConverter.calculateDecValue("MCMCM"));
    }
}
