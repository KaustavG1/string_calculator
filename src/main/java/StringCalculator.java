import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        } else if(Pattern.matches("[0-9]+", numbers)) {
            return Integer.parseInt(numbers);
        } else {
            String arr[] = numbers.split(",");
            return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        }
    }
}
