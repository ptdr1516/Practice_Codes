public class StudentUse {

    public static void main(String[] args) {

        Student s1 = new Student("Purvesh", 593);
        s1.print();
        Student s2 = new Student("Purvesh",586);
        s2.print();
//        System.out.println(s1.numStudents);
//        System.out.println(s2.numStudents);


        Student s3 = new Student("Arthur", 789);
        System.out.println(Student.numStudents);

    }
}
