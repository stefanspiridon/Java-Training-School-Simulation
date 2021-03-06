//GUITrainer subclass that extends the Teacher class
public class GUITrainer extends Teacher {

    //subclass constructor that initialises name gender and age
    GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    //abstract method implemented according to the rules related to the subjects specialism IDs
    @Override
    boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 4;
    }
}
