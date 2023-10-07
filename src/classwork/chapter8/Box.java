package classwork.chapter8;


class Box {
    private double width;
    private double height;
    private double depth;

    // Construct clone of an object
    Box(Box ob) { // pass object to constructor
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // Constructor used when all three dimensions specified
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // Constructor used when no dimensions specified
    Box() {
        width = -1; // use -1 to indicate an uninitialized box
        height = -1;
        depth = -1;
    }

    // Constructor used when cube is created
    Box(double len) {
        width = height = depth = len;
    }

    // Compute and return volume
    double volume() {
        return width * height * depth;
    }


}
