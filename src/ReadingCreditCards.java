import java.lang.reflect.Array;
import java.util.*;
//Imagine that you're writing software for a credit card provider. Your task is to implement a program that will add new credit card accounts, process charges and credits against them, and display summary information.
//
//        You are given a list of commands:
//
//        Add <card_holder> <card_number> $<limit>: Add command will create a new credit card for the given card_holder, card_number, and limit. It is guaranteed that the given card_holder didn't have a credit card before this operation.
//        Card numbers should be validated using the Luhn 10 algorithm.
//        New cards start with a $0 balance.
//        Charge <card_holder> $<amount>: Charge command will increase the balance of the card associated with the provided name by the amount specified.
//        Charges that would raise the balance over the limit are ignored as if they were declined.
//        Charges against Luhn 10 invalid cards are ignored.
//        Credit <card_holder> $<amount>: Credit command will decrease the balance of the card associated with the provided name by the amount specified.
//        Credits that would drop the balance below $0 will create a negative balance.
//        Credits against Luhn 10 invalid cards are ignored.
//        How the Luhn algorithm works:
//
//        Starting with the rightmost digit, which is the check digit, and moving left, double the value of every second digit. If the result of this doubling operation is greater than 9 (e.g., 8 * 2 = 16), then add the digits of the product (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9).
//        Take the sum of all the digits.
//        If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid according to the Luhn algorithm, otherwise it is not valid.
//
//
//        Luhn(number) = 7 + 9 + 9 + 4 + 7 + 6 + 9 + 7 + 7 = 65 = 5 (mod 10) != 0
//
//        Return the card holder names with the balance of the card associated with the provided name. Display "error" instead of the balance if the credit card number does not pass Luhn 10. The names in output should be displayed in lexicographical order.
//
//        Example
//
//        For
//
//        operations = [["Add", "Tom", "4111111111111111", "$1000"],
//        ["Add", "Lisa", "5454545454545454", "$3000"],
//        ["Add", "Quincy", "1234567890123456", "$2000"],
//        ["Charge", "Tom", "$500"],
//        ["Charge", "Tom", "$800"],
//        ["Charge", "Lisa", "$7"],
//        ["Credit", "Lisa", "$100"],
//        ["Credit", "Quincy", "$200"]]
//        the output should be
//
//        solution(operations) = [["Lisa", "$-93"],
//        ["Quincy", "error"],
//        ["Tom", "$500"]]
//        Input/Output
//
//        [execution time limit] 3 seconds (java)
//
//        [input] array.array.string operations
//
//        An array of operations. It is guaranteed that card limits and amounts of each operation are in the range [1, 3000]. It is also guaranteed that each card holder name will contain no more than 10 symbols and each card number will contain from 12 to 16 digits.
//
//        Guaranteed constraints:
//        1 ≤ operations.length ≤ 10,
//        3 ≤ operations[i].length ≤ 4.
//
//        [output] array.array.string
//
//        Array of card holders and their card balances.
//
//        [Java] Syntax Tips
//
//// Prints help message to the console
//// Returns a string
////
//// Globals declared here will cause a compilation error,
//// declare variables inside the function instead!
//        String helloWorld(String name) {
//        System.out.println("This prints to the console when you Run Tests");
//        return "Hello, " + name;
//        }

public class ReadingCreditCards {



    public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }
    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
    public static boolean isValid(long number)
    {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
    }

    static String[][] solution(String[][] operations) {
        String [][] firstArray = new String[3][2];
        String [][] secondArray = new String[3][3];
        int k = 0;
        for(int j=0; j<operations.length; j++){
            if(operations[j][0] == "Add"){
                long cardNumber = Long.parseLong(operations[j][2]);
                if(isValid(cardNumber)){
                    firstArray[k][0] = operations[j][1];
                    firstArray[k][1] = operations[j][3];
                }else{
                    for(int i=0; i<operations[j].length; i++){
                        firstArray[k][0] = operations[j][1];
                        firstArray[k][1] = "error";
                    }
                }
            }
            k++;
        }
        for(int j =0; j<operations.length; j++){
            if(operations[j][0] == "Charge"){
               for(int i=0; i<firstArray.length; i++){
                   if(operations[j][1] == firstArray[i][0]){
                       secondArray[i][0] = firstArray[i][0];
                       secondArray[i][1] = firstArray[i][1];
                       secondArray[i][2] = operations[j][2];
                   }
               }
            }
        }

        return secondArray;
    }


    public static void main(String[] args) {
        String [][] operations = {{"Add", "Tom", "4111111111111111", "$1000"},
                {"Add", "Lisa", "5454545454545454", "$3000"},
                {"Add", "Quincy", "1234567890123456", "$2000"},
                {"Charge", "Tom", "$500"},
                {"Charge", "Tom", "$800"},
                {"Charge", "Lisa", "$7"},
                {"Credit", "Lisa", "$100"},
                {"Credit", "Quincy", "$200"}};

//        System.out.println(solution(operations).toString());
        for(int j =0; j<solution(operations).length; j++){
            System.out.println(Arrays.toString(solution(operations)[j]));
        }
    }
}
