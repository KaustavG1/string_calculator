import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void init() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("Result = 0, if empty string is passed as the argument")
    void addIfEmptyString() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = input number if single number is passed as the argument")
    void addIfSingleNumber() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("123");
        int expectedResult = 123;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of 2 input numbers in the argument string if argument is in the format 'x,y'")
    void addIfDoubleNumber() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("1,2");
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument string if argument is in the format 'x,y,...'")
    void addIfMultipleNumber() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("1,2,3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with comma and new line delimiter")
    void addWithNewLine() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("1\n2,3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with custom delimiter")
    void addWithCustomDelimiter() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("//;\n1;2");
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
        assertEquals(3, stringCalculator.add("//;\n1\n2"));
    }

    @Test
    @DisplayName("Exception should be thrown if any number is negative")
    void addNonNegatives() {
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1"));
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("//;\n-1,25"));
    }

    @Test
    @DisplayName("Exception should be thrown if multiple numbers are negative")
    void addMultipleNonNegatives() {
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("-1,-25,6"));
        assertThrows(NegativesNotAllowedException.class, () -> stringCalculator.add("//[**]\n-1**-25\n6"));
    }

    @Test
    @DisplayName("Result = 0 if input is greater than 1000")
    void addWithOneKiloNumbers() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("0");
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers minus number greater than 1000")
    void addWithMultipleKiloNumbers() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("100\n1,2\n3,1002");
        int expectedResult = 106;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Should match the number of calls made to the add method")
    void callCount() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.GetCalledCount() + 1;
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with custom delimiter of variable length")
    void addWithMultiSizeDelimiters() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("//[***]\n1***2***3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with multiple custom delimiter")
    void addWithMultipleDelimiters() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("//[*][%]\n1*2%3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Result = sum of all numbers in the argument with multiple custom delimiter of variable length")
    void addWithMultipleMultiSizeDelimiters() throws NegativesNotAllowedException {
        int actualResult = stringCalculator.add("//[**][%%]\n1**2%%3");
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

}