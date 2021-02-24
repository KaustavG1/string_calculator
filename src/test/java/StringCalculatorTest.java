import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("Result = 0, if empty string is passed as the argument")
    void addIfEmptyString() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = input number if single number is passed as the argument")
    void addIfSingleNumber() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1123");
        int expectedResult = 1123;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of 2 input numbers in the argument string if argument is in the format 'x,y'")
    void addIfDoubleNumber() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1,2");
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument string if argument is in the format 'x,y,...'")
    void addIfMultipleNumber() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1,2,3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with comma and new line delimiter")
    void addWithNewLine() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("1\n2,3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with custom delimiter")
    void addWithCustomDelimiter() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("//;\n1;2");
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Exception should be thrown if number is negative")
    void addNonNegatives() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1"));
    }
}