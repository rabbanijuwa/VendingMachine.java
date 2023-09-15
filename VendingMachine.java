import java.util.Scanner;
public class VendingMachine {

    private String[][][] products;

    // Constructor method for rows, columns, and depth
    public VendingMachine(int rows, int cols, int depth) {
        products = new String[rows][cols][depth];
    }

    // Method to add products to the vending machine
    public void addProduct(int row, int col, int depth, String productName) {
        if (row >= 0 && row < products.length && col >= 0 && col < products[0].length && depth >= 0 && depth < products[0][0].length) {
            products[row][col][depth] = productName;
        } else {
            System.out.println("Invalid row, column, or depth.");
        }
    }

    public String getProduct(int row, int col, int depth) {
        if (row >= 0 && row < products.length && col >= 0 && col < products[0].length && depth >= 0 && depth < products[0][0].length) {
            String product = products[row][col][depth];
            if (product != null) {
                products[row][col][depth] = null;
                return product; // Return the product if it exists.
            } else {
                return "Empty slot";
            }
        } else {
            return "Invalid location";
        }
    }

    // Method to display the contents
    public void display() {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products[0].length; j++) {
                for (int k = 0; k < products[0][0].length; k++) {
                    String product = products[i][j][k];
                    if (product == null) {
                        System.out.print("[Empty] ");
                    } else {
                        ProductInfo info = getProductInfo(product);
                        System.out.print("[" + product + "] ");
                    }
                }
                System.out.println(); // Move to the next row after printing a row of products.
            }
            System.out.println(); // Add a separator between rows.
        }
    }

    public static ProductInfo getProductInfo(String productName) {
        // Define arrays to store product names and prices
        String[] productNames = {
                "KitKat1", "KitKat2", "KitKat3", "KitKat4", "KitKat5", "KitKat6",
                "Gummy Bears1", "Gummy Bears2", "Gummy Bears3", "Gummy Bears4", "Gummy Bears5", "Gummy Bears6",
                "M&M's1", "M&M's2", "M&M's3", "M&M's4", "M&M's5", "M&M's6",
                "Twix1", "Twix2", "Twix3", "Twix4", "Twix5", "Twix6",
                "Skittles1", "Skittles2", "Skittles3", "Skittles4", "Skittles5", "Skittles6",
                "Reese's Peanut Butter Cups1", "Reese's Peanut Butter Cups2", "Reese's Peanut Butter Cups3", "Reese's Peanut Butter Cups4", "Reese's Peanut Butter Cups5", "Reese's Peanut Butter Cups6",
                "Doritos1", "Doritos2", "Doritos3", "Doritos4", "Doritos5", "Doritos6",
                "Pretzels1", "Pretzels2", "Pretzels3", "Pretzels4", "Pretzels5", "Pretzels6",
                "Cheetos1", "Cheetos2", "Cheetos3", "Cheetos4", "Cheetos5", "Cheetos6",
                "Trail Mi1x", "Trail Mix2", "Trail Mix3", "Trail Mix4", "Trail Mix5", "Trail Mix6",
                "Popcorn1", "Popcorn2", "Popcorn3", "Popcorn4", "Popcorn5", "Popcorn6",
                "Rice Krispies Treats1", "Rice Krispies Treats2", "Rice Krispies Treats3", "Rice Krispies Treats4", "Rice Krispies Treats5", "Rice Krispies Treats6",
                "Dried Mangoes1", "Dried Mangoes2", "Dried Mangoes3", "Dried Mangoes4", "Dried Mangoes5", "Dried Mangoes6",
                "Protein Bar1", "Protein Bar2", "Protein Bar3", "Protein Bar4", "Protein Bar5", "Protein Bar6",
                "Rice Cakes1", "Rice Cakes2", "Rice Cakes3", "Rice Cakes4", "Rice Cakes5", "Rice Cakes6",
                "Veggie Chips1", "Veggie Chips2", "Veggie Chips3", "Veggie Chips4", "Veggie Chips5", "Veggie Chips6",
                "Mixed Berries1", "Mixed Berries2", "Mixed Berries3", "Mixed Berries4", "Mixed Berries5", "Mixed Berries6",
                "Granola Bar1", "Granola Bar2", "Granola Bar3", "Granola Bar4", "Granola Bar5", "Granola Bar6",
                "Iced Coffee1", "Iced Coffee2", "Iced Coffee3", "Iced Coffee4", "Iced Coffee5", "Iced Coffee6",
                "Pepsi1", "Pepsi2", "Pepsi3", "Pepsi4", "Pepsi5", "Pepsi6",
                "Coca-Cola1", "Coca-Cola2", "Coca-Cola3", "Coca-Cola4", "Coca-Cola5", "Coca-Cola6",
                "Iced Tea1", "Iced Tea2", "Iced Tea3", "Iced Tea4", "Iced Tea5", "Iced Tea6",
                "Lemonade1", "Lemonade2", "Lemonade3", "Lemonade4", "Lemonade5", "Lemonade6",
                "Vitamin Water1", "Vitamin Water2", "Vitamin Water3", "Vitamin Water4", "Vitamin Water5", "Vitamin Water6",
                "Fruit Juice1", "Fruit Juice2", "Fruit Juice3", "Fruit Juice4", "Fruit Juice5", "Fruit Juice6",
                "Bottled Water1", "Bottled Water2", "Bottled Water3", "Bottled Water4", "Bottled Water5", "Bottled Water6",
                "Sprite1", "Sprite2", "Sprite3", "Sprite4", "Sprite5", "Sprite6",
                "Energy Drink1", "Energy Drink2", "Energy Drink3", "Energy Drink4", "Energy Drink5", "Energy Drink6",
                "Sour Patch Kids1", "Sour Patch Kids2", "Sour Patch Kids3", "Sour Patch Kids4", "Sour Patch Kids5", "Sour Patch Kids6",
                "Beef Jerky1", "Beef Jerky2", "Beef Jerky3", "Beef Jerky4", "Beef Jerky5", "Beef Jerky6",
                "Whole Wheat Crackers1", "Whole Wheat Crackers2", "Whole Wheat Crackers3", "Whole Wheat Crackers4", "Whole Wheat Crackers5", "Whole Wheat Crackers6",
                "Nut Butter1", "Nut Butter2", "Nut Butter3", "Nut Butter4", "Nut Butter5", "Nut Butter6",
                "Potato Chips1", "Potato Chips2", "Potato Chips3", "Potato Chips4", "Potato Chips5", "Potato Chips6",
                "Starburst1", "Starburst2", "Starburst3", "Starburst4", "Starburst5", "Starburst6",
                "Milky Way1", "Milky Way2", "Milky Way3", "Milky Way4", "Milky Way5",
                "Gum1", "Gum2", "Gum3", "Gum4", "Gum5", "Gum6"
        };

        double[] productPrices = {
                1.25, 1.25, 1.25, 1.25, 1.25, 1.25,
                1.50, 1.50, 1.50, 1.50, 1.50, 1.50,
                1.75, 1.75, 1.75, 1.75, 1.75, 1.75,
                1.30, 1.30, 1.30, 1.30, 1.30, 1.30,
                1.20, 1.20, 1.20, 1.20, 1.20, 1.20,
                1.80, 1.80, 1.80, 1.80, 1.80, 1.80,
                1.40, 1.40, 1.40, 1.40, 1.40, 1.40,
                1.60, 1.60, 1.60, 1.60, 1.60, 1.60,
                1.45, 1.45, 1.45, 1.45, 1.45, 1.45,
                2.00, 2.00, 2.00, 2.00, 2.00, 2.00,
                1.75, 1.75, 1.75, 1.75, 1.75, 1.75,
                1.90, 1.90, 1.90, 1.90, 1.90, 1.90,
                2.20, 2.20, 2.20, 2.20, 2.20, 2.20,
                2.10, 2.10, 2.10, 2.10, 2.10, 2.10,
                1.95, 1.95, 1.95, 1.95, 1.95, 1.95,
                1.70, 1.70, 1.70, 1.70, 1.70, 1.70,
                2.30, 2.30, 2.30, 2.30, 2.30, 2.30,
                2.25, 2.25, 2.25, 2.25, 2.25, 2.25,
                2.10, 2.10, 2.10, 2.10, 2.10, 2.10,
                2.50, 2.50, 2.50, 2.50, 2.50, 2.50,
                1.50, 1.50, 1.50, 1.50, 1.50, 1.50,
                1.55, 1.55, 1.55, 1.55, 1.55, 1.55,
                1.40, 1.40, 1.40, 1.40, 1.40, 1.40,
                1.45, 1.45, 1.45, 1.45, 1.45, 1.45,
                2.20, 2.20, 2.20, 2.20, 2.20, 2.20,
                2.00, 2.00, 2.00, 2.00, 2.00, 2.00,
                1.00, 1.00, 1.00, 1.00, 1.00, 1.00,
                1.60, 1.60, 1.60, 1.60, 1.60, 1.60,
                2.25, 2.25, 2.25, 2.25, 2.25, 2.25,
                1.90, 1.90, 1.90, 1.90, 1.90, 1.90,
                1.80, 1.80, 1.80, 1.80, 1.80, 1.80,
                2.10, 2.10, 2.10, 2.10, 2.10, 2.10,
                1.35, 1.35, 1.35, 1.35, 1.35, 1.35,
                1.75, 1.75, 1.75, 1.75, 1.75, 1.75,
                1.60, 1.60, 1.60, 1.60, 1.60, 1.60,
                1.25, 1.25, 1.25, 1.25, 1.25, 1.25,
        };
        int[] productCalories = {
                218,218,218,218,218,218,
                110,110,110,110,110,110,
                230,230,230,230,230,230,
                286,286,286,286,286,286,
                110,110,110,110,110,110,
                87,87,87,87,87,87,
                240,240,240,240,240,240,
                108,108,108,108,108,108,
                160,160,160,160,160,160,
                240,240,240,240,240,240,
                106,106,106,106,106,106,
                126,126,126,126,126,126,
                120,120,120,120,120,120,
                331,331,331,331,331,331,
                35,35,35,35,35,35,
                134,134,134,134,134,134,
                80,80,80,80,80,80,
                132,132,132,132,132,132,
                100,100,100,100,100,100,
                250,250,250,250,250,250,
                240,240,240,240,240,240,
                91,91,91,91,91,91,
                99,99,99,99,99,99,
                120,120,120,120,120,120,
                136,136,136,136,136,136,
                0,0,0,0,0,0,
                192,192,192,192,192,192,
                110,110,110,110,110,110,
                150,150,150,150,150,150,
                82,82,82,82,82,82,
                120,120,120,120,120,120,
                188,188,188,188,188,188,
                152,152,152,152,152,152,
                160,160,160,160,160,160,
                264,264,264,264,264,264,
                29,29,29,29,29,29
        };
        double[] sugar = {
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
                10.1, 10.2, 10.3, 10.4, 10.5, 10.6,
                10.7, 10.8, 10.9, 11.0, 11.1, 11.2,
                11.3, 11.4, 11.5, 11.6, 11.7, 11.8,
                11.9, 12.0, 12.1, 12.2, 12.3, 12.4,
                12.5, 12.6, 12.7, 12.8, 12.9, 13.0,
                13.1, 13.2, 13.3, 13.4, 13.5, 13.6,
        };


        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].equals(productName)) {
                return new ProductInfo(productPrices[i], productCalories[i], sugar[i], null);
            }
        }

        // If the product name is not found, return a default price (e.g., $1.00)
        return new ProductInfo(1.0, 0, 0.0, null);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the vending machine:");
        System.out.println("Available items:");

        VendingMachine vendingMachine = new VendingMachine(6, 6, 6);

        // Adding products through the addProduct() method
        vendingMachine.addProduct(0, 0, 0, "KitKat1");
        vendingMachine.addProduct(0, 0, 1, "KitKat2");
        vendingMachine.addProduct(0, 0, 2, "KitKat3");
        vendingMachine.addProduct(0, 0, 3, "KitKat4");
        vendingMachine.addProduct(0, 0, 4, "KitKat5");
        vendingMachine.addProduct(0, 0, 5, "KitKat6");
        vendingMachine.addProduct(0, 1, 0, "Gummy Bears1");
        vendingMachine.addProduct(0, 1, 1, "Gummy Bears2");
        vendingMachine.addProduct(0, 1, 2, "Gummy Bears3");
        vendingMachine.addProduct(0, 1, 3, "Gummy Bears4");
        vendingMachine.addProduct(0, 1, 4, "Gummy Bears5");
        vendingMachine.addProduct(0, 1, 5, "Gummy Bears6");
        vendingMachine.addProduct(0, 2, 0, "M&M's1");
        vendingMachine.addProduct(0, 2, 1, "M&M's2");
        vendingMachine.addProduct(0, 2, 2, "M&M's3");
        vendingMachine.addProduct(0, 2, 3, "M&M's4");
        vendingMachine.addProduct(0, 2, 4, "M&M's5");
        vendingMachine.addProduct(0, 2, 5, "M&M's6");
        vendingMachine.addProduct(0, 3, 0, "Twix1");
        vendingMachine.addProduct(0, 3, 1, "Twix2");
        vendingMachine.addProduct(0, 3, 2, "Twix3");
        vendingMachine.addProduct(0, 3, 3, "Twix4");
        vendingMachine.addProduct(0, 3, 4, "Twix5");
        vendingMachine.addProduct(0, 3, 5, "Twix6");
        vendingMachine.addProduct(0, 4, 0, "Skittles1");
        vendingMachine.addProduct(0, 4, 1, "Skittles2");
        vendingMachine.addProduct(0, 4, 2, "Skittles3");
        vendingMachine.addProduct(0, 4, 3, "Skittles4");
        vendingMachine.addProduct(0, 4, 4, "Skittles5");
        vendingMachine.addProduct(0, 4, 5, "Skittles6");
        vendingMachine.addProduct(0, 5, 0, "Reese's Peanut Butter Cups1");
        vendingMachine.addProduct(0, 5, 1, "Reese's Peanut Butter Cups2");
        vendingMachine.addProduct(0, 5, 2, "Reese's Peanut Butter Cups3");
        vendingMachine.addProduct(0, 5, 3, "Reese's Peanut Butter Cups4");
        vendingMachine.addProduct(0, 5, 4, "Reese's Peanut Butter Cups5");
        vendingMachine.addProduct(0, 5, 5, "Reese's Peanut Butter Cups6");
        vendingMachine.addProduct(1, 0, 0, "Doritos1");
        vendingMachine.addProduct(1, 0, 1, "Doritos2");
        vendingMachine.addProduct(1, 0, 2, "Doritos3");
        vendingMachine.addProduct(1, 0, 3, "Doritos4");
        vendingMachine.addProduct(1, 0, 4, "Doritos5");
        vendingMachine.addProduct(1, 0, 5, "Doritos6");
        vendingMachine.addProduct(1, 1, 0, "Pretzels1");
        vendingMachine.addProduct(1, 1, 1, "Pretzels2");
        vendingMachine.addProduct(1, 1, 2, "Pretzels3");
        vendingMachine.addProduct(1, 1, 3, "Pretzels4");
        vendingMachine.addProduct(1, 1, 4, "Pretzels5");
        vendingMachine.addProduct(1, 1, 5, "Pretzels6");
        vendingMachine.addProduct(1, 2, 0, "Cheetos1");
        vendingMachine.addProduct(1, 2, 1, "Cheetos2");
        vendingMachine.addProduct(1, 2, 2, "Cheetos3");
        vendingMachine.addProduct(1, 2, 3, "Cheetos4");
        vendingMachine.addProduct(1, 2, 4, "Cheetos5");
        vendingMachine.addProduct(1, 2, 5, "Cheetos6");
        vendingMachine.addProduct(1, 3, 0, "Trail Mix1");
        vendingMachine.addProduct(1, 3, 1, "Trail Mix2");
        vendingMachine.addProduct(1, 3, 2, "Trail Mix3");
        vendingMachine.addProduct(1, 3, 3, "Trail Mix4");
        vendingMachine.addProduct(1, 3, 4, "Trail Mix5");
        vendingMachine.addProduct(1, 3, 5, "Trail Mix6");
        vendingMachine.addProduct(1, 4, 0, "Popcorn1");
        vendingMachine.addProduct(1, 4, 1, "Popcorn2");
        vendingMachine.addProduct(1, 4, 2, "Popcorn3");
        vendingMachine.addProduct(1, 4, 3, "Popcorn4");
        vendingMachine.addProduct(1, 4, 4, "Popcorn5");
        vendingMachine.addProduct(1, 4, 5, "Popcorn6");
        vendingMachine.addProduct(1, 5, 0, "Rice Krispies Treats1");
        vendingMachine.addProduct(1, 5, 1, "Rice Krispies Treats2");
        vendingMachine.addProduct(1, 5, 2, "Rice Krispies Treats3");
        vendingMachine.addProduct(1, 5, 3, "Rice Krispies Treats4");
        vendingMachine.addProduct(1, 5, 4, "Rice Krispies Treats5");
        vendingMachine.addProduct(1, 5, 5, "Rice Krispies Treats6");
        vendingMachine.addProduct(2, 0, 0, "Dried Mangoes1");
        vendingMachine.addProduct(2, 0, 1, "Dried Mangoes2");
        vendingMachine.addProduct(2, 0, 2, "Dried Mangoes3");
        vendingMachine.addProduct(2, 0, 3, "Dried Mangoes4");
        vendingMachine.addProduct(2, 0, 4, "Dried Mangoes5");
        vendingMachine.addProduct(2, 0, 5, "Dried Mangoes6");
        vendingMachine.addProduct(2, 1, 0, "Protein Bar1");
        vendingMachine.addProduct(2, 1, 1, "Protein Bar2");
        vendingMachine.addProduct(2, 1, 2, "Protein Bar3");
        vendingMachine.addProduct(2, 1, 3, "Protein Bar4");
        vendingMachine.addProduct(2, 1, 4, "Protein Bar5");
        vendingMachine.addProduct(2, 1, 5, "Protein Bar6");
        vendingMachine.addProduct(2, 2, 0, "Rice cakes1");
        vendingMachine.addProduct(2, 2, 1, "Rice cakes2");
        vendingMachine.addProduct(2, 2, 2, "Rice cakes3");
        vendingMachine.addProduct(2, 2, 3, "Rice cakes4");
        vendingMachine.addProduct(2, 2, 4, "Rice cakes5");
        vendingMachine.addProduct(2, 2, 5, "Rice cakes6");
        vendingMachine.addProduct(2, 3, 0, "Veggie Chips1");
        vendingMachine.addProduct(2, 3, 1, "Veggie Chips2");
        vendingMachine.addProduct(2, 3, 2, "Veggie Chips3");
        vendingMachine.addProduct(2, 3, 3, "Veggie Chips4");
        vendingMachine.addProduct(2, 3, 4, "Veggie Chips5");
        vendingMachine.addProduct(2, 3, 5, "Veggie Chips6");
        vendingMachine.addProduct(2, 4, 0, "Mixed berries1");
        vendingMachine.addProduct(2, 4, 1, "Mixed berries2");
        vendingMachine.addProduct(2, 4, 2, "Mixed berries3");
        vendingMachine.addProduct(2, 4, 3, "Mixed berries4");
        vendingMachine.addProduct(2, 4, 4, "Mixed berries5");
        vendingMachine.addProduct(2, 4, 5, "Mixed berries6");
        vendingMachine.addProduct(2, 5, 0, "Granola Bar1");
        vendingMachine.addProduct(2, 5, 1, "Granola Bar2");
        vendingMachine.addProduct(2, 5, 2, "Granola Bar3");
        vendingMachine.addProduct(2, 5, 3, "Granola Bar4");
        vendingMachine.addProduct(2, 5, 4, "Granola Bar5");
        vendingMachine.addProduct(2, 5, 5, "Granola Bar6");
        vendingMachine.addProduct(3, 0, 0, "Iced Coffee1");
        vendingMachine.addProduct(3, 0, 1, "Iced Coffee2");
        vendingMachine.addProduct(3, 0, 2, "Iced Coffee3");
        vendingMachine.addProduct(3, 0, 3, "Iced Coffee4");
        vendingMachine.addProduct(3, 0, 4, "Iced Coffee5");
        vendingMachine.addProduct(3, 0, 5, "Iced Coffee6");
        vendingMachine.addProduct(3, 1, 0, "Pepsi1");
        vendingMachine.addProduct(3, 1, 1, "Pepsi2");
        vendingMachine.addProduct(3, 1, 2, "Pepsi3");
        vendingMachine.addProduct(3, 1, 3, "Pepsi4");
        vendingMachine.addProduct(3, 1, 4, "Pepsi5");
        vendingMachine.addProduct(3, 1, 5, "Pepsi6");
        vendingMachine.addProduct(3, 2, 0, "Coca-Cola1");
        vendingMachine.addProduct(3, 2, 1, "Coca-Cola2");
        vendingMachine.addProduct(3, 2, 2, "Coca-Cola3");
        vendingMachine.addProduct(3, 2, 3, "Coca-Cola4");
        vendingMachine.addProduct(3, 2, 4, "Coca-Cola5");
        vendingMachine.addProduct(3, 2, 5, "Coca-Cola6");
        vendingMachine.addProduct(3, 3, 0, "Iced Tea1");
        vendingMachine.addProduct(3, 3, 1, "Iced Tea2");
        vendingMachine.addProduct(3, 3, 2, "Iced Tea3");
        vendingMachine.addProduct(3, 3, 3, "Iced Tea4");
        vendingMachine.addProduct(3, 3, 4, "Iced Tea5");
        vendingMachine.addProduct(3, 3, 5, "Iced Tea6");
        vendingMachine.addProduct(3, 4, 0, "Lemonade1");
        vendingMachine.addProduct(3, 4, 1, "Lemonade2");
        vendingMachine.addProduct(3, 4, 2, "Lemonade3");
        vendingMachine.addProduct(3, 4, 3, "Lemonade4");
        vendingMachine.addProduct(3, 4, 4, "Lemonade5");
        vendingMachine.addProduct(3, 4, 5, "Lemonade6");
        vendingMachine.addProduct(3, 5, 0, "Vitamin Water1");
        vendingMachine.addProduct(3, 5, 1, "Vitamin Water2");
        vendingMachine.addProduct(3, 5, 2, "Vitamin Water3");
        vendingMachine.addProduct(3, 5, 3, "Vitamin Water4");
        vendingMachine.addProduct(3, 5, 4, "Vitamin Water5");
        vendingMachine.addProduct(3, 5, 5, "Vitamin Water6");
        vendingMachine.addProduct(4, 0, 0, "Fruit Juice1");
        vendingMachine.addProduct(4, 0, 1, "Fruit Juice2");
        vendingMachine.addProduct(4, 0, 2, "Fruit Juice3");
        vendingMachine.addProduct(4, 0, 3, "Fruit Juice4");
        vendingMachine.addProduct(4, 0, 4, "Fruit Juice5");
        vendingMachine.addProduct(4, 0, 5, "Fruit Juice6");
        vendingMachine.addProduct(4, 1, 0, "Bottled Water1");
        vendingMachine.addProduct(4, 1, 1, "Bottled Water2");
        vendingMachine.addProduct(4, 1, 2, "Bottled Water3");
        vendingMachine.addProduct(4, 1, 3, "Bottled Water4");
        vendingMachine.addProduct(4, 1, 4, "Bottled Water5");
        vendingMachine.addProduct(4, 1, 5, "Bottled Water6");
        vendingMachine.addProduct(4, 2, 0, "Sprite1");
        vendingMachine.addProduct(4, 2, 1, "Sprite2");
        vendingMachine.addProduct(4, 2, 2, "Sprite3");
        vendingMachine.addProduct(4, 2, 3, "Sprite4");
        vendingMachine.addProduct(4, 2, 4, "Sprite5");
        vendingMachine.addProduct(4, 2, 5, "Sprite6");
        vendingMachine.addProduct(4, 3, 0, "Energy Drink1");
        vendingMachine.addProduct(4, 3, 1, "Energy Drink2");
        vendingMachine.addProduct(4, 3, 2, "Energy Drink3");
        vendingMachine.addProduct(4, 3, 3, "Energy Drink4");
        vendingMachine.addProduct(4, 3, 4, "Energy Drink5");
        vendingMachine.addProduct(4, 3, 5, "Energy Drink6");
        vendingMachine.addProduct(4, 4, 0, "Sour Patch Kids1");
        vendingMachine.addProduct(4, 4, 1, "Sour Patch Kids2");
        vendingMachine.addProduct(4, 4, 2, "Sour Patch Kids3");
        vendingMachine.addProduct(4, 4, 3, "Sour Patch Kids4");
        vendingMachine.addProduct(4, 4, 4, "Sour Patch Kids5");
        vendingMachine.addProduct(4, 4, 5, "Sour Patch Kids6");
        vendingMachine.addProduct(4, 5, 0, "Beef Jerky1");
        vendingMachine.addProduct(4, 5, 1, "Beef Jerky2");
        vendingMachine.addProduct(4, 5, 2, "Beef Jerky3");
        vendingMachine.addProduct(4, 5, 3, "Beef Jerky4");
        vendingMachine.addProduct(4, 5, 4, "Beef Jerky5");
        vendingMachine.addProduct(4, 5, 5, "Beef Jerky6");
        vendingMachine.addProduct(5, 0, 0, "Whole Wheat Crackers1");
        vendingMachine.addProduct(5, 0, 1, "Whole Wheat Crackers2");
        vendingMachine.addProduct(5, 0, 2, "Whole Wheat Crackers3");
        vendingMachine.addProduct(5, 0, 3, "Whole Wheat Crackers4");
        vendingMachine.addProduct(5, 0, 4, "Whole Wheat Crackers5");
        vendingMachine.addProduct(5, 0, 5, "Whole Wheat Crackers6");
        vendingMachine.addProduct(5, 1, 0, "Nut Butter1");
        vendingMachine.addProduct(5, 1, 1, "Nut Butter2");
        vendingMachine.addProduct(5, 1, 2, "Nut Butter3");
        vendingMachine.addProduct(5, 1, 3, "Nut Butter4");
        vendingMachine.addProduct(5, 1, 4, "Nut Butter5");
        vendingMachine.addProduct(5, 1, 5, "Nut Butter6");
        vendingMachine.addProduct(5, 2, 0, "Potato Chips1");
        vendingMachine.addProduct(5, 2, 1, "Potato Chips2");
        vendingMachine.addProduct(5, 2, 2, "Potato Chips3");
        vendingMachine.addProduct(5, 2, 3, "Potato Chips4");
        vendingMachine.addProduct(5, 2, 4, "Potato Chips5");
        vendingMachine.addProduct(5, 2, 5, "Potato Chips6");
        vendingMachine.addProduct(5, 3, 0, "Starburst1");
        vendingMachine.addProduct(5, 3, 1, "Starburst2");
        vendingMachine.addProduct(5, 3, 2, "Starburst3");
        vendingMachine.addProduct(5, 3, 3, "Starburst4");
        vendingMachine.addProduct(5, 3, 4, "Starburst5");
        vendingMachine.addProduct(5, 3, 5, "Starburst6");
        vendingMachine.addProduct(5, 4, 0, "Milky Way1");
        vendingMachine.addProduct(5, 4, 1, "Milky Way2");
        vendingMachine.addProduct(5, 4, 2, "Milky Way3");
        vendingMachine.addProduct(5, 4, 3, "Milky Way4");
        vendingMachine.addProduct(5, 4, 4, "Milky Way5");
        vendingMachine.addProduct(5, 4, 5, "Milky Way6");
        vendingMachine.addProduct(5, 5, 0, "Gum1");
        vendingMachine.addProduct(5, 5, 1, "Gum2");
        vendingMachine.addProduct(5, 5, 2, "Gum3");
        vendingMachine.addProduct(5, 5, 3, "Gum4");
        vendingMachine.addProduct(5, 5, 4, "Gum5");
        vendingMachine.addProduct(5, 5, 5, "Gum6");


        // ... Add more products as needed

        // Display the vending machine contents
        vendingMachine.display();

        //initialize total amount
        double totalAmount = 0.0;
        //ask user to input money


        //endless loop to prompt the customer to input the row, column, and depth of the item they want
        while (true) {
            System.out.print("Enter row (0-5): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-5): ");
            int col = scanner.nextInt();

            System.out.print("Enter depth (0-5): ");
            int depth = scanner.nextInt();

            // Check if the input is valid
            if (row >= 0 && row < 6 && col >= 0 && col < 6 && depth >= 0 && depth < 6) {
                String product = vendingMachine.getProduct(row, col, depth);

                if (product.equals("Empty slot")) {
                    System.out.println("The selected slot is empty.");
                } else if (product.equals("Invalid location")) {
                    System.out.println("Invalid location.");
                } else {

                    System.out.println("You have purchased: " + product);
                    ProductInfo productPriceInfo = getProductInfo(product);
                    double productPrice = productPriceInfo.getPrice();
                    System.out.println("Price: $" + productPrice);
                    totalAmount +=  productPrice;
                }
            } else {
                System.out.println("Invalid input. Please enter valid row, column, and depth.");
                break;
            }


            System.out.print("Do you want to continue shopping? (yes/no): ");
            String continueShopping = scanner.next();

            if (continueShopping.equalsIgnoreCase("no")) {
                System.out.print("Enter the amount of cash you want to insert: $");
                double customerMoney = scanner.nextDouble();
                if (totalAmount > customerMoney) {
                    double change = totalAmount - customerMoney;
                    System.out.println("Not enough money. Please insert $" + change + " more.");
                    break; // Exit the loop
                } else {
                    System.out.println("Change: $" + (customerMoney - totalAmount));
                    System.out.println("Total Amount: $" + totalAmount);
                    System.out.println("Product is dispensing...");
                    System.out.println("Thank you for your purchases!");
                }
                break; // Exit the loop if the user doesn't want to continue shopping

            }
        }
    }
}