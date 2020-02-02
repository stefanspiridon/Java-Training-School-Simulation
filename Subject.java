//Subject class
public class Subject {

    //this is the unique ID of the subject
    private int id;

    //this is the specialism ID of the subject.
    private int specialism;

    //this is the duration (number of days)
    // required for any course covering the subject
    private int duration;

    //this is the string description of the subjec
    private String description;

    //course instance variable that represents
    //the assigned course of the subject
    private Course course;

    //subject class constructor that initialises
    //the id, specialism and duration
    Subject(int id, int specialism, int duration){
        this.id=id;
        this.specialism=specialism;
        this.duration=duration;
    }

    //setter method for the course instance variable
    void setCourse(Course course){
        this.course=course;
    }

    //getter method that returns the course of the subject
    Course getCourse(){
        return course;
    }

    //getter method that returns the id of the subject
    int getID(){
        return id;
    }

    //getter method that returns the specialism of the subject
    int getSpecialism(){
        return specialism;
    }

    //getter method that returns the duration of the subject
    int getDuration(){
        return duration;
    }

    //getter method that returns the description of the subject
    String getDescription(){
        return description;
    }

    //setter method that sets the description of the subject
    void setDescription(String description){
        this.description=description;
    }
}
