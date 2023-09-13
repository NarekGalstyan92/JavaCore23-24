package classwork.chapter6;


class Box {
    double width;
    double height;
    double depth;

    // display volume of the box
    double volume() {
        return width * height * depth;
    }

    // set dimensions of box
    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
