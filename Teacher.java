//Teacher subclass that extends the Instructor class
public class Teacher extends Instructor{

    //subclass constructor that initialises name gender and age
    Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }

    //abstract method implemented according to the rules related to the subjects specialism IDs
    @Override
    boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2;
    }
}
