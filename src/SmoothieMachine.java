import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmoothieMachine {

    private static final Map<String, List<String>> MENU = Map.of(
            "Classic", Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey"),
            "Freezie", Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"),
            "Greenie", Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice"),
            "Just Desserts", Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")
    );

    public static String ingredients(String order) {
        String[] parts;
        try {
            parts = order.split(",");

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        String smoothieName = parts[0];
        if (!MENU.containsKey(smoothieName)) {
            throw new IllegalArgumentException();
        }

        List<String> ingredients = new ArrayList<>(MENU.get(smoothieName));

        Stream.of(parts)
                .skip(1)  // Skip the first part as in your for-loop
                .forEach(ingredient -> {
                    if (ingredient.startsWith("-")) {
                        ingredients.remove(ingredient.substring(1));
                    } else if (ingredients.contains(ingredient) || !MENU.get(smoothieName).contains(ingredient)) {
                        throw new IllegalArgumentException();
                    }
                });


        return ingredients.stream().sorted().collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        //System.out.println(ingredients("Classic,-strawberry,-peanut")); // Outputs: banana,honey,mango,peach,pineapple
        System.out.println(ingredients("Classic,mango")); // Uncommenting this line will throw an exception
        // System.out.println(ingredients("Vitamin smoothie")); // Uncommenting this line will throw an exception
    }
}
