import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("Result should be 0 if empty string is passed as the argument")
    void add() {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("");
        int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }
}