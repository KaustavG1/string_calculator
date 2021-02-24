import java.util.regex.Pattern;

public class StringCalculator {
    // To keep count of add method
    private static int addCallCount = 0;

    public int add(String numbers) throws NegativesNotAllowedException {
        // Add Counter
        addCallCount++;
        // Empty String check
        if(numbers.equals("")) {
            return 0;
        }
        // Single Number check
        else if(Pattern.matches("[0-9]+", numbers)) {
            int singleInput = Integer.parseInt(numbers);
            if(singleInput < 0) {
                // Throw Exception if number is negative
                throw new NegativesNotAllowedException("Negatives not allowed; " + singleInput + " was passed");
            }
            // Return appropriate value depending on number
            return (Integer.parseInt(numbers) < 1001) ? Integer.parseInt(numbers) : 0;
        }
        // Multiple number check //;\n1;2;3
        else {
            String delimiter;
            // If Input contains "//" then set custom delimiter and trim off extra characters
            if(numbers.contains("//")) {
                delimiter = String.valueOf(numbers.charAt(2));
                String temp[] = numbers.replace("\n", delimiter).split(delimiter, 2);
                numbers = temp[1].substring(1);
            }
            // Else set delimiter as "," and trim extra characters
            else {
                delimiter = ",";
                numbers = numbers.replace("\n", delimiter);
            }
            // Split the input based on the delimiter
            String arr[] = numbers.split(delimiter);
            int result = 0;
            StringBuilder stringBuilder = new StringBuilder();
            // Loop over the array and calculate the result; If number is negative append it to the string builder
            for(String a : arr) {
                if(Integer.parseInt(a) < 0) {
                    stringBuilder.append(a).append(" ");
                }
                result += (Integer.parseInt(a) < 1001) ? Integer.parseInt(a) : 0;
            }
            // If Length of accumulated string is non zero then throw exception
            if(stringBuilder.toString().length() > 0) {
                throw new NegativesNotAllowedException("Negatives not allowed; " + stringBuilder.toString() + " was passed");
            }
            // return result
            return result;
        }
    }

    // Getter for the add invocation count
    public int GetCalledCount() {
        return addCallCount;
    }

}

//public class StringCalculator {
//    private static int addCallCount = 0;
//
//    public int add(String numbers) throws NegativesNotAllowedException {
//        addCallCount++;
//        if(numbers.equals("")) {
//            return 0;
//        } else if(Pattern.matches("[0-9]+", numbers)) {
//            int singleInput = Integer.parseInt(numbers);
//            if(singleInput < 0) {
//                throw new NegativesNotAllowedException("Negatives not allowed; " + singleInput + " was passed");
//            }
//            return (Integer.parseInt(numbers) < 1001) ? Integer.parseInt(numbers) : 0;
//        } else {
//            numbers = numbers.replace("\n", ",");
//            String arr[] = numbers.split(",");
//            int result = 0;
//            StringBuilder stringBuilder = new StringBuilder();
//            for(String a : arr) {
//                if(Integer.parseInt(a) < 0) {
//                    stringBuilder.append(a).append(" ");
//                }
//                result += (Integer.parseInt(a) < 1001) ? Integer.parseInt(a) : 0;
//            }
//            if(stringBuilder.toString().length() > 0) {
//                throw new NegativesNotAllowedException("Negatives not allowed; " + stringBuilder.toString() + " was passed");
//            }
//            return result;
//        }
//    }
//
//    public int GetCalledCount() {
//        return addCallCount;
//    }
//
//}