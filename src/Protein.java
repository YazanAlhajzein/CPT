public class Protein extends Ingredient {
    public Protein(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ": protein";
    }
}