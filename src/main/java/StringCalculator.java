import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) throws NegativesNotAllowedException {
        if(numbers.equals("")) {
            return 0;
        } else if(Pattern.matches("[0-9]+", numbers)) {
            int singleInput = Integer.parseInt(numbers);
            if(singleInput < 0) {
                throw new NegativesNotAllowedException("Negatives not allowed; " + singleInput + " was passed");
            }
            return (Integer.parseInt(numbers) < 1001) ? Integer.parseInt(numbers) : 0;
        } else {
            numbers = numbers.replace("\n", ",");
            String arr[] = numbers.split(",");
            int result = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for(String a : arr) {
                if(Integer.parseInt(a) < 0) {
                    stringBuilder.append(a).append(" ");
                }
                result += Integer.parseInt(a);
            }
            if(stringBuilder.toString().length() > 0) {
                throw new NegativesNotAllowedException("Negatives not allowed; " + stringBuilder.toString() + " was passed");
            }
            return result;
        }
    }
}

//public class StringCalculator {
//    public int add(String numbers) throws NegativesNotAllowedException {
//        if(numbers.equals("")) {
//            return 0;
//        } else if(Pattern.matches("[0-9]+", numbers)) {
//            int singleInput = Integer.parseInt(numbers);
//            if(singleInput < 0) {
//                throw new NegativesNotAllowedException("Negatives not allowed; " + singleInput + " was passed");
//            }
//            return Integer.parseInt(numbers);
//        } else {
//            numbers = numbers.replace("\n", ",");
//            String arr[] = numbers.split(",");
//            int result = 0;
//            StringBuilder stringBuilder = new StringBuilder();
//            for(String a : arr) {
//                if(Integer.parseInt(a) < 0) {
//                    stringBuilder.append(a).append(" ");
//                }
//                result += Integer.parseInt(a);
//            }
//            if(stringBuilder.toString().length() > 0) {
//                throw new NegativesNotAllowedException("Negatives not allowed; " + stringBuilder.toString() + " was passed");
//            }
//            return result;
//        }
//    }
//}