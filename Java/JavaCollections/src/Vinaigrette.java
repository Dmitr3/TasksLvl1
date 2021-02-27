public class Vinaigrette extends Salad{
    public Vinaigrette() {
        setname("Vinaigrette");

        addIngredient(new Potato(500));
        addIngredient(new Carrot(150));
        addIngredient(new Beta(250));
        addIngredient(new Cucumber());
    }
}
