package classwork.chapter7;


class Box {
    double width;
    double height;
    double depth;

    // Notice this constructor. It takes an object of type Box.
    Box(Box ob) {
        width = ob.width;;
        height = ob.height;
        depth = ob.depth;
    }

    // Constructor used when all three dimensions specified
    Box(double w, double h, double d) {
        System.out.println("Constructing Box.");
        width = w;
        height = h;
        depth = d;
    }

    // Constructor used when no dimensions specified
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // Constructor used when cube is created
    Box(double len) {
        System.out.println("Constructing Box.");
        width = height = depth = len;
    }

    // Compute and return volume
    double volume() {
        return width * height * depth;
    }


}
