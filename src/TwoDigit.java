public class TwoDigit {
    static int solution(int n) {
        String number = Integer.toString(n);
        char[] string1 = number.toCharArray();

        int one = Integer.parseInt(String.valueOf(string1[0]));
        int two = Integer.parseInt(String.valueOf(string1[1]));
        return one+two;
    }

    public static void main(String[] args) {
        System.out.println(solution(23));

//        Softwares1234@
    }
}
