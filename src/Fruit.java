public class Fruit extends Ingredient {
    public Fruit(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ": fruit";
    }
}