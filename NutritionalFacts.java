public class NutritionalFacts {
    private double productPrices;
    private int calories;
    private double sugar;
    private ProductCategory productCategory;

    public NutritionalFacts(double productPrices, int calories, double sugar, ProductCategory productCategory) {
        this.productPrices = productPrices;
        this.calories = calories;
        this.sugar = sugar;
        this.productCategory = productCategory;
    }
    public double getPrice() {
        return productPrices;
    }
    public void setPrice(){
        this.productPrices = productPrices;
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
    public ProductCategory getProductCategory(){
        return productCategory;
    }
    public void stBreed(){
        this.productCategory = productCategory;
    }
}


