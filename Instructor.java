//abstract subclass that extends the instructor superclass
public abstract class Instructor extends Person {

    private Course assignedCourse; //this is the course that is assigned to the instructor

    //subclass constructor that initialises name gender and age
    Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    //setter method to assign the input course to the instructor
    void assignCourse(Course course){
        assignedCourse =course;
    }

    //method that removes the assigned course to the instructor
    void unassignCourse(){
        assignedCourse =null;
    }

    //getter method that returns the assigned course to the instructor if any
    Course getAssignedCourse(){
        return assignedCourse;
    }

    //declaration of an abstract method which returns a boolean
    //the method states whether the instructor can teach the subject
    //(has the right specialism)
    abstract boolean canTeach(Subject subject);




}
