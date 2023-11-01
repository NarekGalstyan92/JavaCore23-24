package classwork.chapter12;

import java.lang.reflect.Method;

public class Marker {

    // Annotate a method using a marker.
    // Notice that no () is needed.
    @MyMarker
    public static void myMeth() {
        Marker ob = new Marker();

        try {
            Method m = ob.getClass().getMethod("myMeth");

            // Determine if the annotation is present.
            if (m.isAnnotationPresent(MyMarker.class)) {
                System.out.println("Marker is present");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
