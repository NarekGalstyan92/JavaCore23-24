package classwork.chapter12;

// Demonstrate ordinal(), compareTo(), and equals()

// An enumeration of apple varieties
enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

    private double price; // price of each apple

    // Constructor
    Apple(int p) {
        price = p;

    }

    Apple() {
    }

    public double getPrice() {
        return price;
    }
}
