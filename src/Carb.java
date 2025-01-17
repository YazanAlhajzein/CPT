public class Carb extends Ingredient {
    public Carb(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ": carb";
    }
}
