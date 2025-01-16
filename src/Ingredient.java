public class Ingredient {
    protected String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingredient that = (Ingredient) obj;
        return name != null ? name.equals(that.name) : that.name == null;
    } //ChatGPT help

    @Override
    public String toString() {
        return name;
    }
}