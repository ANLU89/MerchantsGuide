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
    void validNumeralMMCM() throws Exception {
        assertEquals(2900, RomanToDecConverter.calculateDecValue("MMCM"));
    }
    @Test
    void validNumeralMMMCM() throws Exception {
        assertEquals(3900, RomanToDecConverter.calculateDecValue("MMMCM"));
    }
    @Test
    void invalidNumeralMMMMCM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("MMMMCM");
        });
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
    void invalidNumeralCMM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("CMM");
        });
    }
    @Test
    void invalidNumeralMCMCM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("MCMCM");
        });
    }
    @Test
    void invalidNumeralMCMXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("MCMXCXL");
        });
    }  
    @Test
    void invalidNumeralIXIV() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("IXIV");
        });
    } 
    @Test
    void invalidNumeralIVIX() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("IVIX");
        });
    }
    @Test
    void invalidNumeralXXXM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("XXXM");
        });
    }
    @Test
    void invalidNumeralXXC() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("XXC");
        });
    }
    @Test
    void invalidNumeralXXXC() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("XXXC");
        });
    }
    @Test
    void validNumeralMMMCMXLIX() throws Exception {
        assertEquals(3949, RomanToDecConverter.calculateDecValue("MMMCMXLIX"));
    }
    @Test
    void validNumeralMMMCDXLIX() throws Exception {
        assertEquals(3449, RomanToDecConverter.calculateDecValue("MMMCDXLIX"));
    }
    @Test
    void invalidNumeralMMMCDXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("MMMCDXCXL");
        });
    }
    @Test
    void invalidNumeralXXMM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("XXMM");
        });
    }
    @Test
    void invalidNumeralCXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            RomanToDecConverter.calculateDecValue("CXCXL");
        });
    }
    
}
