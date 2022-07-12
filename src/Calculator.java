import java.util.Scanner;

/**
 * @author Nursultan
 * Sheralievnursultan@gmail.com
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println(calc(userInput));
    }

    public static String calc(String userInput) throws Exception {
        String[] source = userInput.split("");
        char operator = 0;
        int indexOfOperator = 0;
        for (int i = 0; i < source.length; i++) {
            switch (source[i]) {
                case "+":
                    operator = '+';
                    indexOfOperator = i;
                    break;
                case "-":
                    operator = '-';
                    indexOfOperator = i;
                    break;
                case "*":
                    operator = '*';
                    indexOfOperator = i;
                    break;
                case "/":
                    operator = '/';
                    indexOfOperator = i;
                    break;
            }
        }

        String num1 = getNumber1(source, indexOfOperator);
        String num2 = getNumber2(source, indexOfOperator);
        int result;

        if (source.length == 3 && areLatinNumbers(userInput)) {
            int a = Integer.parseInt(source[0]);
            int b = Integer.parseInt(source[2]);
            result = calculated(a, operator, b);
            return String.valueOf(result);
        } else if (areRoman(num1) && areRoman(num2)) {
            int romanNum1 = romanToNumber(num1);
            int romanNum2 = romanToNumber(num2);
            if (romanNum1 <= 10 && romanNum2 <= 10) {
                result = calculated(romanNum1, operator, romanNum2);
                if (result > 0) {
                    return numberToRom(result);
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    private static String numberToRom(int number) {
        String[] roman = {
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        for (int i = 0; i < roman.length - 1; i++) {
            if (number == i) {
                return roman[i];
            }
        }
        return null;
    }

    private static int calculated(int a, char operator, int b) {
        int result = 0;
        switch (operator) {
            case '+': {
                result = a + b;
                break;
            }
            case '-': {
                result = a - b;
                break;
            }
            case '*': {
                result = a * b;
                break;
            }
            case '/': {
                result = a / b;
                break;
            }
            default: {
                //исключение
            }
        }
        return result;
    }

    private static int romanToNumber(final String num1) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < roman.length - 1; i++) {
            if (num1.equals(roman[i])) {
                return i;
            }
        }
        return 0;//исключение
    }

    private static boolean areRoman(String num) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String s : roman) {
            if (num.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areLatinNumbers(String array) {
        char a = array.charAt(0);
        char b = array.charAt(2);
        return '0' < a && a <= '9' && '0' < b && b <= '9';
    }

    private static String getNumber2(String[] array, int index) {
        StringBuilder num2 = new StringBuilder();
        for (int i = index + 1; i < array.length; i++) {
            num2.append(array[i]);
        }
        return num2.toString();
    }

    private static String getNumber1(String[] array, int index) {
        StringBuilder num1 = new StringBuilder();
        for (int i = 0; i < index; i++) {
            num1.append(array[i]);
        }
        return num1.toString();
    }
}
