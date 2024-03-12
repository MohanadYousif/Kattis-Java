import java.util.Scanner;

class Ingredient {
    String name;
    double weight;
    double percentage;

    Ingredient(String name, double weight, double percentage) {
        this.name = name;
        this.weight = weight;
        this.percentage = percentage;
    }
}

public class BakersPercentage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().replaceAll("[^0-9]", "").trim());

        for (int t = 1; t <= testCases; t++) {
            String[] input = scanner.nextLine().replaceAll("[^0-9 ]", "").trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int originalPortions = Integer.parseInt(input[1]);
            int desiredPortions = Integer.parseInt(input[2]);

            Ingredient[] ingredients = new Ingredient[n];

            for (int i = 0; i < n; i++) {
                input = scanner.nextLine().split(" ");
                String name = input[0];
                double weight = Double.parseDouble(input[1]);
                double percentage = Double.parseDouble(input[2]);
                ingredients[i] = new Ingredient(name, weight, percentage);
            }

            scaleRecipe(t, ingredients, originalPortions, desiredPortions);
        }

        scanner.close();
    }

    private static void scaleRecipe(int caseNumber, Ingredient[] ingredients, int originalPortions, int desiredPortions) {
        double scalingFactor = (double) desiredPortions / originalPortions;
        double mainIngredientWeight = 0;

        for (Ingredient ingredient : ingredients) {
            if (ingredient.percentage == 100) {
                mainIngredientWeight = ingredient.weight * scalingFactor;
                break;
            }
        }

        System.out.println("Recipe # " + caseNumber);

        for (Ingredient ingredient : ingredients) {
            double scaledWeight = ingredient.percentage * mainIngredientWeight / 100;
            System.out.printf("%s %.1f%n", ingredient.name, scaledWeight);
        }

        System.out.println("----------------------------------------");
    }
}