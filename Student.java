import java.util.ArrayList;

//Student subclass that extends the Person superclass
public class Student extends Person {

    //this is the collections of subject IDs that the student has obtained.
    private ArrayList<Integer> certificates = new ArrayList<>();
    private Course course;

    //subclass constructor to initialise name, age, gender and certificates
    Student(String name, char gender, int age) {
        super(name, gender, age);
    }

    //method that adds the ID of the subject tot the collections of certificates
    void graduate(Subject subject){
        certificates.add(subject.getID());
        //the student is no longer attending the course
        course=null;
    }

    //getter method that returns the ArrayList of certificates obtained by students
    ArrayList<Integer> getCertificates(){
        return certificates;
    }

    //method that checks whether or not the student has already obtained the certificate for the input subject
    boolean hasCertificate(Subject subject) {
        return certificates.contains(subject.getID());
    }

    //setter method that sets the course that the student is enrolled on
    void setCourseEnrolledOn(Course course){
        this.course=course;
    }

    //getter method that returns the course that the student is enrolled on
    Course getCourseEnrolledOn(){
        return course;
    }
}
