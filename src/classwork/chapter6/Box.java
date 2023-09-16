package classwork.chapter6;


class Box {
    double width;
    double height;
    double depth;


    //This is the constructor for the Box.
    Box() {
        System.out.println("Constructing Box.");
        width = 10;
        height = 10;
        depth = 10;
    }
    Box(double w, double h, double d) {
        System.out.println("Constructing Box.");
        width = w;
        height = h;
        depth = d;
    }


    // display volume of the box
    double volume() {
        return width * height * depth;
    }

//    // set dimensions of box
//    void setDim(double w, double h, double d){
//        width = w;
//        height = h;
//        depth = d;
//    }
}
