//Person superclass
public class Person {

    //this is the name of the person
    private String name;

    // this defines whether the person is male (‘M’) or female (‘F’)
    private char gender;

    //this says how old the person is in years
    private int age;

    //constructor that initialises name, gender, age
    Person(String name, char gender, int age){
        this.name=name;
        this.gender=gender;
        this.age=age;
    }

    //getter method that returns name
    String getName(){
        return name;
    }

    //getter methd that returns gender
    char getGender(){
        return gender;
    }

    //setter method to set the age of the person
    void setAge(int age){
        this.age=age;
    }

    //getter method to return the age of the person
    int getAge(){
        return age;
    }
}
