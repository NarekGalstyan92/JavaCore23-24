package classwork.chapter8;

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // override area for rectangle
    @java.lang.Override
    double area() {
        System.out.println("Inside Area for rectangle");
        return dim1 * dim2;
    }
}
