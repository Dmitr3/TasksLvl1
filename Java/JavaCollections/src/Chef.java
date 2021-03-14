import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

/**
 * This class realizes the main logic of the program, provides methods to
 * create salad, manage its ingredients, sort ingredients.
 */
public class Chef {
    private String name; // chef's name
    private Salad salad; // salad that he cooks

    /**
     * Default constructor. Chef's name is Bob, he cooks unknown salad.
     */
    public Chef() {
        name = "Bob";
        salad = new Salad();
    }

    /**
     * Constructor with parameter. Find another chef - named 'name'.
     * @param name the name of the chef
     */
    public Chef(String name) {
        this.name = name;
        salad = new Salad();
    }

    /**
     * Constructor with parameters 'name' - chef's name, 'salad' - salad to
     * work with.
     * @param name chef's name
     * @param salad the salad to work with
     */
    public Chef(String name, Salad salad) {
        this.name = name;
        this.salad = salad;
    }

    /**
     * Creates ingredient by parameters entered by user from the console.
     * @return returns a reference to a newly created Vegetable or null if
     * it was not created
     */
    public Vegetable getIngredient() throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the ingredient: ");
        String ingredientName = in.nextLine();
        System.out.println("Enter the weight: ");
        double weight = in.nextDouble();
        Vegetable vegetable;

        switch (ingredientName){
            case "Beta":
                 vegetable = new Beta(weight);
                break;
            case "Carrot":
                 vegetable = new Carrot(weight);
                break;
            case "Potato":
                 vegetable = new Potato(weight);
                break;
            case "Tomato":
                 vegetable = new Tomato(weight);
                break;
            case "Cucumber":
                 vegetable = new Cucumber(weight);
                break;
            default:
                throw new Exception("No such ingredient!");
        }

        return vegetable;
    }

    /**
     * Displays the ingredients for a given range of calories.
     * @param scanner the input source
     */
    public void showIngredientsForCalories(Scanner scanner) {
        double lowerCalories, upperCalories;

        System.out.println("Enter the lower limit:");
        try {
            lowerCalories = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input!");
            scanner.next();

            return;
        }

        System.out.println("Enter the upper limit:");
        try {
            upperCalories = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input!");
            scanner.next();

            return;
        }

        salad.showIngredientsByCalories(lowerCalories, upperCalories);
    }

    /**
     * Shows all the available options for user.
     */
    public void showOptions() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        Vegetable vegetable = null;

        System.out.println("Hello! My name is " + name + ".");
        System.out.println("What do you want to cook today?");

        while (choice != 0) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Set salad name");
            System.out.println("2. Show recipe");
            System.out.println("3. Add ingredient");
            System.out.println("4. Sort ingredients by calories");
            System.out.println("5. Sort ingredients by weight");
            System.out.println("6. Get ingredients for calories");
            System.out.println("0. Exit");

            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong option!");
                scanner.next();
                choice = -1;
            }

            switch(choice) {
                case 1:
                    System.out.println("Name your salad:");
                    salad.setname(scanner.next());
                    break;

                case 2:
                    salad.showRecipe();
                    break;

                case 3:
                    vegetable = getIngredient();
                    if (vegetable != null) {
                        if (!salad.addIngredient(vegetable)) {
                            System.out.println("Cannot add ingredient!");
                        }
                    }
                    break;

                case 4:
                    salad.sortIngredientsByCalories();
                    break;

                case 5:
                    salad.sortIngredientsByWeight();
                    break;

                case 6:
                    showIngredientsForCalories(scanner);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

        scanner.close();
    }
}