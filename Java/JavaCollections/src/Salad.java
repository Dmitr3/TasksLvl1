//package chef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {

    private String name; // the name of the salad
    private List<Vegetable> ingredients = new ArrayList<Vegetable>();

    public Salad() {
        name = "Unknown";
    }

    public Salad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<?> getIngredients() {
        return ingredients;
    }

    public void setname(String name) {
        this.name = name;
    }

    public boolean addIngredient(Vegetable vegetable) {
        return ingredients.add(vegetable);
    }

    public void showRecipe() {
        if (ingredients.isEmpty()) {
            System.out.println("You haven't added any ingredients yet!");

            return;
        }

        System.out.println("The salad " + name + " contains:");
        for (Vegetable vegetable : ingredients) {
            System.out.println(vegetable.toString());
        }
        System.out.println("----------------------------");
        System.out.println("Total energy: " + countCalories() + "kcal");
    }

    public double countCalories() {
        double calories = 0.0;

        for (Vegetable vegetable : ingredients) {
            calories += vegetable.getTotalCalories();
        }

        return calories;
    }

    public void sortIngredientsByCalories() {
        Collections.sort(ingredients, new CaloriesComparator());
    }

    public void sortIngredientsByWeight() {
        Collections.sort(ingredients, new WeightComparator());
    }

    public void showIngredientsByCalories(double lowerCalories,
                                          double upperCalories) {
        double calories;

        System.out.println("Ingredients for calories ["
                + lowerCalories + ", " + upperCalories + "]");
        for (Vegetable vegetable : ingredients) {
            calories = vegetable.getCalories();
            if (calories >= lowerCalories && calories <= upperCalories) {
                System.out.println(vegetable.getName() + ", "
                        + vegetable.getCalories() + "kcal per 100g");
            }
        }
    }
}