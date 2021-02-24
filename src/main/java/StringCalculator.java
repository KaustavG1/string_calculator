import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) throws NegativesNotAllowedException {
        if(numbers.equals("")) {
            return 0;
        } else if(Pattern.matches("[0-9]+", numbers)) {
            int singleInput = Integer.parseInt(numbers);
            if(singleInput < 0) {
                throw new NegativesNotAllowedException();
            }
            return Integer.parseInt(numbers);
        } else {
            numbers = numbers.replace("\n", ",");
            String arr[] = numbers.split(",");
            int result = 0;
            for(String a : arr) {
                if(Integer.parseInt(a) < 0) {
                    throw new NegativesNotAllowedException();
                }
                result += Integer.parseInt(a);
            }
            return  result;
        }
    }
}