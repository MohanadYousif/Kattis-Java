import java.util.function.Predicate;

public class CapitalUse {
    public static void main(String[] args) {

    }

    //  first Solution
    /*public static boolean detectCapitalUse(String word) {
        int numberIfCapitals = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                numberIfCapitals++;
            }
        }
        if (numberIfCapitals == word.length() || numberIfCapitals == 0) return true;
        return numberIfCapitals == 1 && Character.isUpperCase(word.charAt(0));
    }*/

    // 3rd Solution
    public static boolean detectCapitalUse(String word) {
        if(word.length() <= 1) return true;
        Predicate<Character> correctCase = Character::isLowerCase;

        for(int i = 1; i < word.length(); i++){
            if(!correctCase.test(word.charAt(i))) return false;
        }
        return false;
    }
}
