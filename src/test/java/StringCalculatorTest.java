import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("Result should be 0 if empty string is passed as the argument")
    void addIfEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result should be the passed number if single number is passed as the argument")
    void addIfSingleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1123");
        int expectedResult = 1123;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result should be the sum of numbers in the argument string if argument is in the format 'x,y'")
    void addIfDoubleNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1,2");
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }
}