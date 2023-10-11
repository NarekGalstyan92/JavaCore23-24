package classwork.chapter8;


class AbstractAreas {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);

        Figure figRef; // this is OK, no object created

        figRef = r;
        System.out.println("Area is: " + figRef.area());
        figRef = t;
        System.out.println("Area is: " + figRef.area());
    }
}
