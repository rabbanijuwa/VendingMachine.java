public class NutritionalFacts {
    private int calories;
    private double sugar;
    private double fat;
    private double protein;
    private ProductCategory productCategory;

    public NutritionalFacts(int calories, double sugar, double fat, double protein, ProductCategory productCategory) {
        this.calories = calories;
        this.sugar = sugar;
        this.fat = fat;
        this.protein = protein;
        this.productCategory = productCategory;
    }
    public int getCalories() {
        return calories;
    }

    public void setCalories(){
        this.calories = calories;
    }

    public double getSugar() {
        return sugar;
    }
    public void setSugar(){
        this.sugar = sugar;
    }

    public double getFat() {
        return fat;
    }
    public void setFat(){
       this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }
    public void setProtein(){
        this.protein = protein;
    }
    public ProductCategory getProductCategory(){
        return productCategory;
    }
    public void stBreed(){
        this.productCategory = productCategory;
    }
}


