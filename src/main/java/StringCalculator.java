import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        } else if(Pattern.matches("[0-9]+", numbers)) {
            return Integer.parseInt(numbers);
        } else {
            // ToDo: Implement Logic to make test case pass
            return 0;
        }
    }
}
