
public class FuzzBuzz {
    public static void main(String[] args) {
        int value = reverseByString(8463412);
        if (value != 0) System.out.println(value);
        else System.out.println("The result of input number is out of the range of integr values.");
    }

    private static int reverse(int input){
        int reversed = 0;
        while (input != 0){
            reversed = reversed * 10 + input % 10;
            input = input / 10;
        }
        return reversed;
    }

    private static int reverseByString(int input){
        StringBuilder sb = new StringBuilder();
        String inputString = String.valueOf(input);
        for (int i = inputString.length() - 1; i >= 0; i--){
            sb.append(inputString.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }
}
