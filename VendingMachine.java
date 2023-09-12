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
                        System.out.print("[" + product + "] ");
                    }
                }
                System.out.println(); // Move to the next row after printing a row of products.
            }
            System.out.println(); // Add a separator between rows.
        }
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(6, 6, 6);

        // Adding products through the addProduct() method
        vendingMachine.addProduct(0,0,0,"KitKat");
        vendingMachine.addProduct(0,1,1,"Gummy Bears");
        vendingMachine.addProduct(0,2,2,"M&M's");
        vendingMachine.addProduct(0,3,3, "Twix");
        vendingMachine.addProduct(0,4,4,"Skittles");
        vendingMachine.addProduct(0,5,5,"Reese's Peanut Butter Cups");
        vendingMachine.addProduct(1,0,6,"Dorito");
        vendingMachine.addProduct(1,1,0,"Pretzels");
        vendingMachine.addProduct(1,2,1,"Cheetos");
        vendingMachine.addProduct(1,3,2,"Trail Mix");
        vendingMachine.addProduct(1,4,3,"Popcorn");
        vendingMachine.addProduct(1,5,4,"Rice Krispies Treats");
        vendingMachine.addProduct(2,0,5,"Dried Mangoes");
        vendingMachine.addProduct(2,1,0,"Protein Bar");
        vendingMachine.addProduct(2,2,1,"Rice cakes");
        vendingMachine.addProduct(2,3,2,"Veggie Chips");
        vendingMachine.addProduct(2,4,3,"Mixed berries");
        vendingMachine.addProduct(2,5,4,"Granola Bar");


        // ... Add more products as needed

        // Display the vending machine contents
        vendingMachine.display();
    }
}
