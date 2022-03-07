package MerchantsGuide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanToDecConverterTest {

    RomanToDecConverter converter = new RomanToDecConverter();
    @Test 
    void invalidRepeatofV() {

        assertFalse(converter.isValidRepeat('V'));
    }
    @Test 
    void validRepeatofC() {
        assertTrue(converter.isValidRepeat('C'));
    }
    @Test 
    void invalidCharacterlH() {
        assertFalse(converter.isValidCharacter('H'));
    }
    @Test
    void validCharacterX() {
        assertTrue(converter.isValidCharacter('X'));
    }
    @Test
    void validNumeralIV() throws Exception {
        assertEquals(4, converter.calculateDecValue("IV"));
    }
    @Test
    void validNumeralMIX() throws Exception {
        assertEquals(1009, converter.calculateDecValue("MIX"));
    }
    @Test
    void validNumeralMMM() throws Exception {
        assertEquals(3000, converter.calculateDecValue("MMM"));
    }
    @Test
    void validNumeralCM() throws Exception {
        assertEquals(900, converter.calculateDecValue("CM"));
    }
    @Test
    void validNumeralMCM() throws Exception {
        assertEquals(1900, converter.calculateDecValue("MCM"));
    }
    @Test
    void validNumeralMMCM() throws Exception {
        assertEquals(2900, converter.calculateDecValue("MMCM"));
    }
    @Test
    void validNumeralMMMCM() throws Exception {
        assertEquals(3900, converter.calculateDecValue("MMMCM"));
    }
    @Test
    void invalidNumeralMMMMCM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("MMMMCM");
        });
    }
    @Test
    void validNumeralMCMXLIV() throws Exception {
        assertEquals(1944, converter.calculateDecValue("MCMXLIV"));
    }
    @Test
    void validNumeralMMMCMXLIV() throws Exception {
        assertEquals(3944, converter.calculateDecValue("MMMCMXLIV"));
    }
    @Test
    void invalidNumeralCMM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("CMM");
        });
    }
    @Test
    void invalidNumeralMCMCM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("MCMCM");
        });
    }
    @Test
    void invalidNumeralMCMXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("MCMXCXL");
        });
    }  
    @Test
    void invalidNumeralIXIV() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("IXIV");
        });
    } 
    @Test
    void invalidNumeralIVIX() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("IVIX");
        });
    }
    @Test
    void invalidNumeralXXXM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("XXXM");
        });
    }
    @Test
    void invalidNumeralXXC() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("XXC");
        });
    }
    @Test
    void invalidNumeralXXXC() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("XXXC");
        });
    }
    @Test
    void validNumeralMMMCMXLIX() throws Exception {
        assertEquals(3949, converter.calculateDecValue("MMMCMXLIX"));
    }
    @Test
    void validNumeralMMMCDXLIX() throws Exception {
        assertEquals(3449, converter.calculateDecValue("MMMCDXLIX"));
    }
    @Test
    void invalidNumeralMMMCDXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("MMMCDXCXL");
        });
    }
    @Test
    void invalidNumeralXXMM() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("XXMM");
        });
    }
    @Test
    void invalidNumeralCXCXL() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("CXCXL");
        });
    }
    @Test
    void invalidNumeralCXCXC() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            converter.calculateDecValue("CXCXC");
        });
    }
    
}
