import java.util.ArrayList;

//course class
public class Course {

    // this is the subject associated with the course
    private Subject subject;

    //this is the number of days until the course starts
    private int daysUntilStarts;

    //this is the number of days that the course still has to run
    private int daysToRun;

    //instance variable of a student arrayList that represents the enrolled students
    private ArrayList<Student> enrolled;

    //instance variable of an instructor that is assigned to the course
    private Instructor instructor;

    //instance variable of a student array that is used to return the information
    //in the arrayList in an array form
    private Student[] enrolledArray;

    //boolean variable that states if the course is cancelled or not
    private boolean cancelled=false;

    //boolean variable that states if the course is finished or not
    private boolean finished =false;

    //constructor that initialises the subject, daysUntilStarts
    //daysToRun from the duration of the subject and associates
    // this course with the subject, enrolled arrayList, enrolledArray
    Course(Subject subject, int daysUntilStarts){
        this.subject=subject;
        this.daysUntilStarts=daysUntilStarts;
        daysToRun=subject.getDuration();
        subject.setCourse(this);
        enrolled = new ArrayList<>();
        enrolledArray = new Student[enrolled.size()];
    }

    //getter method that returns the subject
    Subject getSubject(){
        return subject;
    }

    //getter method that returns the status of the course
    int getStatus(){

        //If the course has finished, then return 0
        if(daysToRun==0){
            return 0;
        }

        if(daysUntilStarts>0){
            //if the course has not started, then return the negative
            // of the number of days until the course starts
            return (-daysUntilStarts);
        }else{
            //if the course is currently running, then return
            // the number of days left until the course finishes.
            return daysToRun;
        }
    }

    //method that advances one day for the course
    void aDayPasses(){
        //advance a day
        daysUntilStarts--;

        //if it starts
        if(daysUntilStarts==0) {

            //cancel the course when the course starts without any
            //instructor or students,
            if (instructor==null || enrolled.isEmpty()) {

                //cancel the course
                cancelled = true;

                //release the students
                for(Student student : enrolled){
                    student.setCourseEnrolledOn(null);
                }

                //clear the arrayList of enrolled students
                enrolled.clear();

                //unassign the instructor from the course
                // when the course finishes
                if(instructor!=null){
                    instructor.unassignCourse();
                }

                //release the instructor when the course is cancelled
                instructor=null;
            }
        }

        //at this point the course started
        if(daysUntilStarts<0){

            //advance with one day
            while (daysToRun>0) {
                daysToRun--;
                break;
            }

            //if the course is finished
            if(daysToRun==0){

                //change the boolean finnished to true
                finished =true;

                //graduate the enrolled students
                for (Student student : this.enrolled) {
                    student.graduate(subject);
                }

                //clear the arrayList of enrolled students
                enrolled.clear();

                //unassign the instructor from the course
                // when the course finishes
                if(instructor!=null){
                    instructor.unassignCourse();
                }

                //release the instructor when the course is cancelled
                instructor=null;
            }
        }
    }

    //method that adds the student to the collection of enrolled students
    //and returns a boolean indicating if the registration is successful or not
    boolean enrolStudent(Student student){
        if(this.enrolled.size() >= 3){
            //The course is full
            return false;
        }else if(daysUntilStarts==0){
            //The course has already started.
            return false;
        }else if(student.getCourseEnrolledOn()!=null){
            //the student id already enrolled on a course
            return false;
        }else{
            //enroll the student
            enrolled.add(student);

            //set the course variable from student class to this
            student.setCourseEnrolledOn(this);

            //the enrollment was successful
            return true;
        }
    }

    //getter method to return the number of students enrolled in the course
    int getSize(){
        return enrolled.size();
    }

    //getter method that returns the Student[] array of students enrolled in the course
    Student[] getStudents(){
        //moves to contents of the enrolled ArrayList into an array
        enrolledArray =enrolled.toArray(enrolledArray);
        return enrolledArray;
    }

    //setter method to set the instructor to the course
    boolean setInstructor(Instructor instructor){
        //if the instructor has the right specialism, he can teach the course
        if(instructor.canTeach(subject)){
            this.instructor=instructor;
            //assigning the instructor was successful
            return true;
        }else{
            //assigning the instructor was not successful
            return false;
        }
    }

    //method that returns whether the course has an instructor or not
    boolean hasInstructor(){
        return instructor != null;
    }

    //method that returns the boolean value of whether the course is cancelled or not
    boolean isCancelled(){
        return this.cancelled;
    }

    //method that returns the boolean value of whether the course is finished or not
    boolean isFinished(){
        return this.finished;
    }

    //getter method that returns the instructor assigned to the course
    Instructor getInstructor(){
        return instructor;
    }

    //method that checks whether the course has a subject assigned to it
    boolean hasSubject(){
        return subject != null;
    }
}
