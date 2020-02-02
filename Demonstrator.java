//Demonstrator subclass that extends the Instructor class
public class Demonstrator extends Instructor {

    //subclass constructor that initialises name gender and age
    Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    //abstract method implemented according to the rules related to the subjects specialism IDs
    @Override
    boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 2;
    }
}
