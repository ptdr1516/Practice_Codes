public class Student {

    public String name;
    private int rollno;
    double cgpa;
    final static double CONVERSIONFACTOR = 0.95;
    static int numStudents;
    public Student(String n, int m){
        this.name = n;
        numStudents++;
        this.rollno = numStudents;


    }
    public static int getNumStudents(){
        return numStudents;
    }
    public Student(String n){
        name = n;
        numStudents++;
        this.rollno = numStudents;
    }
    public Student(){
        name = "Himanshu";
        rollno = 589;
    }
    public void print(){
        System.out.println(name + " " + rollno);
    }
}

