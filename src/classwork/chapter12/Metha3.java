package classwork.chapter12;

import java.lang.reflect.Method;

class Metha3 {
    // Annotate a method using the default values;
    @MyAnno
    public static void myMeth() {
        Metha3 ob = new Metha3();

        // Obtain the annotation for this method and display the values of the members

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
