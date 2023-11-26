package classwork.chapter14.compare;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CompareExample {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Set<Student> students = new TreeSet<>(new AgeComparator());
        List<Student> students = new ArrayList<>();
        students.add(new Student("poxos", "poxosyan", 23, simpleDateFormat.parse("02-01-2023")));
        students.add(new Student("aram", "poxosyan", 23, simpleDateFormat.parse("02-03-2023")));
        students.add(new Student("zaven", "poxosyan", 33, simpleDateFormat.parse("02-02-2023")));

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }

    }
}
