import java.util.regex.Pattern;

public class StringCalculator {
    /*public static void main(String[] args) throws NegativesNotAllowedException {
        System.out.println(add("//[***]\n1***2***3"));
    }*/

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
            String delimiter = "";
            // If Input contains "//" then set custom delimiter and trim off extra characters
            if(numbers.contains("//") && numbers.charAt(2) != '[') {
                delimiter = String.valueOf(numbers.charAt(2));
                String temp[] = numbers.replace("\n", delimiter).split(delimiter, 2);
                numbers = temp[1].substring(1);
            }

            // If input contains delimiters starting in the format '//[delims]...' then
            else if (numbers.contains("//") && numbers.charAt(2) == '[') {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
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
                        position = i;
                    }
                }
                String delim1 = sb.toString();
                String delim2 = sb2.toString();

//                System.out.println(delim1 + " " + delim2 + " " + position);       //[***][;;;]\n1***2;;;3
                numbers = numbers.replace("\n", delim1.charAt(0) + "").replace(delim1, delim1.charAt(0) + "");
//                String s = numbers.replace("\n", delim1.charAt(0) + "");
//                System.out.println(s + " replace new line");
//                s = s.replace(delim1, delim1.charAt(0) + "");
//                System.out.println(s + " replace delim1");
                int delim2End = 0;
                if(delim2.length() > 0) {
                    numbers = numbers.replace(delim2, delim1.charAt(0) + "");
//                    System.out.println(s);
                    delim2End = 3;
                }
                numbers = numbers.substring(6 + delim2End);
//                System.out.println(s);
                int result = 0;
                String arr [] = numbers.split("\\" + delim1.charAt(0));

                // String[] nums = numbers.replace(delim1, String.valueOf(delim1.charAt(0))).replace(delim2, String.valueOf(delim1.charAt(0))).split("" + delim1.charAt(0));

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