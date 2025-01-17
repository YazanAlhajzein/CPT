public class Vegetable extends Ingredient {
    public Vegetable(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ": vegetable";
    }
}