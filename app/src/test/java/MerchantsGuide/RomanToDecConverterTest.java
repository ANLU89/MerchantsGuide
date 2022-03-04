package MerchantsGuide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanToDecConverterTest {
    @Test 
    void invalidRepeatofV() {
        assertFalse(RomanToDecConverter.isValidRepeat('V'));
    }
}
