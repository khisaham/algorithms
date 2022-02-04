//You've been asked to program a bot for a popular bank that will automate the management of incoming requests.
// Every request has its own timestamp in seconds, and it is guaranteed that all requests come sequentially,
// i.e. the timestamp is strictly increasing. There are two types of incoming requests:
//
//        deposit <timestamp> <holder_id> <amount> — request to deposit <amount> amount of money in the <holder_id> account;
//        withdraw <timestamp> <holder_id> <amount> — request to withdraw <amount> amount of money from the <holder_id> account. As a bonus, bank also provides a cashback policy — 2% of the withdrawn amount rounded down to the nearest integer will be returned to the account exactly 24 hours after the request timestamp. If the cashbask and deposit/withdrawal happen at the same timestamp, assume cashback happens earlier.
//        Your system should also handle invalid requests. There are two types of invalid requests:
//
//        invalid account number;
//        withdrawal of a larger amount of money than is currently available.
//        For the given list of initial balances and requests, return the state of balances straight after the last request has been processed, or an array of a single element [-<request_id>] (please note the minus sign), where <request_id> is the 1-based index of the first invalid request. Note that cashback requests which haven't happened before the last request should be ignored.
//
//        Example
//
//        Example 1
//        For balances = [1000, 1500] and requests = ["withdraw 1613327630 2 480", "withdraw 1613327644 2 800", "withdraw 1614105244 1 100", "deposit 1614108844 2 200", "withdraw 1614108845 2 150"], the output should be solution(balances, requests) = [900, 295].
//
//        Explanation
//        Here are the states of balances after each request:
//
//        initially: [1000, 1500];
//        "withdraw 1613327630 2 480": [1000, 1020];
//        "withdraw 1613327644 2 800": [1000, 220];
//        At 1613414030 the 2nd account will receive the cashback of 480 * 0.02 = 9.6, which is rounded down to 9: [1000, 229];
//        At 1613414044 the 2nd account will receive the cashback of 800 * 0.02 = 16: [1000, 245];
//        "withdraw 1614105244 1 100": [900, 245];
//        "deposit 1614108844 2 200": [900, 445];
//        "withdraw 1614108845 2 150": [900, 295], which is the answer.
//        Cashbacks for the last two withdrawals happen at 1614191644 and 1614195245, which is after the last request timestamp 1614108845, so they are ignored.
//        Example 2
//        For balances = [20, 1000, 500, 40, 90] and requests = ["deposit 1613327630 3 400", "withdraw 1613327635 1 20", "withdraw 1613327651 1 50", "deposit 1613327655 1 50"], the output should be solution(balances, requests) = [-3].
//
//        Explanation
//        Here are the states of balances after each request:
//
//        initially: [20, 1000, 500, 40, 90];
//        "deposit 1613327630 3 400": [20, 1000, 900, 40, 90];
//        "withdraw 1613327635 1 20": [0, 1000, 900, 40, 90];
//        "withdraw 1613327651 1 50": it is not possible to withdraw 50 from the 1st account, so the request is invalid.
//        the rest of the requests are not processed
//        Input/Output
//
//        [execution time limit] 3 seconds (java)
//
//        [input] array.integer balances
//
//        Array of integers, where balances[i] is the amount of money in the (i + 1)th account.
//
//        Guaranteed constraints:
//        1 ≤ balances.length ≤ 100,
//        0 ≤ balances[i] ≤ 105.
//
//        [input] array.string requests
//
//        Array of requests in the order they should be processed. Each request is guaranteed to be in the format described above. It is guaranteed that requests come sequentially, i.e. the timestamp strictly increases.
//
//        Guaranteed constraints:
//        1 ≤ requests.length ≤ 100.
//
//        [output] array.integer
//
//        The balances after executing all of the requests or array with a single integer - the index of the first invalid request preceded by -.
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
//
//        1234
//        int[] solution(int[] balances, String[] requests) {
//
//        }
//
//        TESTS
//        CUSTOM TESTS

import java.util.Arrays;

public class BotForBank {
    static int[] solution(int[] balances, String[] requests) {
        for (int idx = 0; idx < requests.length; idx ++) {
            String[] r = requests [idx].split(" ");
            if (r [0].equalsIgnoreCase("deposit")) {
                int aIdx = Integer.valueOf(r [1]) - 1,
                        sum = Integer.valueOf(r [2]);

                if (aIdx >= balances.length) return new int [] { - (idx + 1) };
                balances [aIdx] += sum;
            }
            else if (r [0].equalsIgnoreCase("withdraw")) {
                int aIdx = Integer.valueOf(r [1]) - 1,
                        sum = Integer.valueOf(r [2]);

                if (aIdx >= balances.length || balances [aIdx] < sum) return new int [] { - (idx + 1) };
                balances [aIdx] -= sum;
            }

            else return new int [] { - (idx + 1) };
        }
        return balances;
    }

    public static void main(String[] args) {
        int [] balances = {1000, 1500};
        String [] request = {"withdraw 1613327630 2 480", "withdraw 1613327644 2 800", "withdraw 1614105244 1 100", "deposit 1614108844 2 200", "withdraw 1614108845 2 150"};
        System.out.println(Arrays.toString(solution(balances, request)));
    }

}
