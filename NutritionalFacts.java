public class NutritionalFacts {
    private int calories;
    private double sugar;
    private double fat;
    private double protein;

    public NutritionalFacts(int calories, double sugar, double fat, double protein) {
        this.calories = calories;
        this.sugar = sugar;
        this.fat = fat;
        this.protein = protein;
    }
    public int getCalories() {
        return calories;
    }

    public double getSugar() {
        return sugar;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    @Override
    public String toString() {
        return "Calories: " + calories + " | Sugar: " + sugar + "g | Fat: " + fat + "g | Protein: " + protein + "g";
    }

}
