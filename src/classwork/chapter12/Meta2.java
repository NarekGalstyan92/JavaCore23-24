package classwork.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@What(description = "An annotation test class")
@MyAnno(str = "Metha2", val = 99)
public class Meta2 {

    // Annotate a method.
    @What(description = "An annotation test class")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation[] annos = ob.getClass().getAnnotations();
            // Display all annotations from Meta2
            System.out.println("All annotations from Meta2: ");
            for (Annotation anno : annos) {
                System.out.println(anno);
            }
            System.out.println();

            // Display all annotations from myMeth.
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();

            System.out.println("All annotations from myMeth : ");
            for (Annotation annotation : annos) {
                System.out.println(annotation);
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }

}
