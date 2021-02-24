import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if(numbers.equals("")) {
            return 0;
        } else if(Pattern.matches("[0-9]+", numbers)) {
            return Integer.parseInt(numbers);
        } else {
            numbers = numbers.replace("\n", ",");
            String arr[] = numbers.split(",");
            int result = 0;
            for(String a : arr) {
                result += Integer.parseInt(a);
            }
            return  result;
        }
    }
}
