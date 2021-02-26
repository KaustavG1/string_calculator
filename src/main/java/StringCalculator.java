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

        // Multiple number check //;\n1;2\n3 or //;\n1;2;3
        else {
            String delimiter = ",";

            // If Input contains "//"  then set custom delimiter and trim off extra characters
            if(numbers.contains("//") && numbers.charAt(2) != '[') {
                String delim = String.valueOf(numbers.charAt(2));
                String temp[] = numbers.split("\\n", 2);
                numbers = temp[1].replace("\n", delimiter).replace(delim, delimiter);
            }

            // If input contains delimiters starting in the format '//[delims]...' then
            else if (numbers.contains("//") && numbers.charAt(2) == '[') {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                // Initialize variable to keep track of first delimiter position
                int position = 0;

                // Calculate first delimiter and position of last character of it
                for(int i = 3; i < numbers.length(); i++) {
                    if(numbers.charAt(i) == ']') {
                        break;
                    }
                    sb.append(numbers.charAt(i));
                    position = i;
                }

                // If input contains a second delimiter in the format '//[delim1][delim2]...' then
                if(numbers.charAt(position + 2) == '[') {

                    // Calculate second delimiter
                    for(int i = position + 3; i < numbers.length(); i++) {
                        if(numbers.charAt(i) == ']') {
                            break;
                        }
                        sb2.append(numbers.charAt(i));
                    }
                }

                String delim1 = sb.toString();
                String delim2 = sb2.toString();

                // Create an new string by replacing all new line characters and variable length delimiters with single length delimiter of one type
                numbers = numbers.replace("\n", delimiter).replace(delim1, delimiter);

                int delim2End = 0;

                // Calculate second delimiter's length if present
                if(delim2.length() > 0) {
                    numbers = numbers.replace(delim2, delimiter);
                    delim2End = 3;
                }

                // Create new string containing only the delimiter separated numbers
                numbers = numbers.substring(6 + delim2End);

                return calculateSum(numbers, delimiter);
            }

            // Else set delimiter as "," and trim extra characters
            else {
                numbers = numbers.replace("\n", ",");
            }

            // return result
            return calculateSum(numbers, delimiter);
        }
    }

    private static int calculateSum(String numbers, String delimiter) throws NegativesNotAllowedException {
        // Split the input based on the delimiter
        String arr[] = numbers.split(delimiter);
        // Initialize the accumulator and a string builder to catch all negative numbers
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

    // Getter for the add invocation count
    public int GetCalledCount() {
        return addCallCount;
    }

}