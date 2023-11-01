package classwork.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class RepeatAnno {

    // Repeat MyAnno on myMeth()
    @MyAnno(str = "First annotation", val = -1)
    @MyAnno(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i) {
        RepeatAnno ob = new RepeatAnno();

        try {
            Class<?> c = ob.getClass();

            // Obtain the annotations for myMeth()
            Method m = c.getMethod("myMeth", String.class, int.class);

            // Display the repeated MyAnno annotations.
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 100);
    }
}
