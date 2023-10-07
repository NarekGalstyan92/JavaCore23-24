package classwork.chapter8;

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // override area for triangle

    @java.lang.Override
    double area() {
        System.out.println("Inside Area for triangle");
        return dim1 * dim2 / 2;
    }
}
