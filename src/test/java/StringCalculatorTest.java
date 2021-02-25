import org.junit.jupiter.api.BeforeEach;
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
        int actualResult = stringCalculator.add("123");
        int expectedResult = 123;
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
    @DisplayName("Exception should be thrown if any number is negative")
    void addNonNegatives() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1"));
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1,25"));
    }

    @Test
    @DisplayName("Exception should be thrown if multiple numbers are negative")
    void addMultipleNonNegatives() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1,-25,6"));
//        stringCalculator.add("-1,-2,-100,-4152,-8,25");
    }

    @Test
    @DisplayName("Result = 0 if input is greater than 1000")
    void addWithOneKiloNumbers() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("0");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers minus number greater than 1000")
    void addWithMultipleKiloNumbers() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("100\n1,2\n3,1002");
        int expectedResult = 106;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Should match the number of calls made to the add method")
    void callCount() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.GetCalledCount();
        int expectedResult = 10;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with custom delimiter of variable length")
    void addWithMultiSizeDelimiters() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("//[***]\n1***2***3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with multiple custom delimiter")
    void addWithMultipleDelimiters() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("//[*][%]\\n1*2%3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with multiple custom delimiter of variable length")
    void addWithMultipleMultiSizeDelimiters() throws NegativesNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();
        int actualResult = stringCalculator.add("//[**][%%]\\n1**2%%3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

}