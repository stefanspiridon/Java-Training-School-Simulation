import java.util.ArrayList;
import java.util.Iterator;

//School class is where all our Students are taught and our Instructors work
public class School {

    //String variable that represents the name of the school
    private String name;

    //instance variable of a Subject ArrayList
    private ArrayList<Subject> subjectList;

    //instance variable of a course ArrayList
    private ArrayList<Course> courseList;

    //instance variable of a Student ArrayList
    private ArrayList<Student> studentList;

    //instance variable of an Instructor ArrayList
    private ArrayList<Instructor> instructorList;

    //constructor to initialise the school name
    //and the different lists of objects
    School(String name){
        this.name=name;
        subjectList = new ArrayList<>();
        courseList = new ArrayList<>();
        studentList = new ArrayList<>();
        instructorList = new ArrayList<>();
    }


    //method to add a student to the studentList of the school
    void add(Student student){
        studentList.add(student);
    }

    //method to remove a student from the studentList of the school
    void remove(Student student){
        studentList.remove(student);
    }

    //getter method to return studentList
    ArrayList<Student> getStudents(){
        return studentList;
    }

    //method to add a subject to the subjectList of the school
    void add(Subject subject){
        subjectList.add(subject);
    }

    //method to remove a subject from the subjectList of the school
    void remove(Subject subject){
        subjectList.remove(subject);
    }

    //getter method to return subjectList
    ArrayList<Subject> getSubjects(){
        return subjectList;
    }

    //method to add a course to the courseList of the school
    void add(Course course){
        courseList.add(course);
    }

    //method to remove a course from the courseList of the school
    void remove(Course course){
        courseList.remove(course);
    }

    //getter method to return courseList
    ArrayList<Course> getCourses(){
        return courseList;
    }

    //method to add a instructor to the instructorList of the school
    void add(Instructor instructor){
        instructorList.add(instructor);
    }

    //method to remove a instructor from the instructorList of the school
    void remove(Instructor instructor){
        instructorList.remove(instructor);
    }

    //getter method to return instructorList
    ArrayList<Instructor> getInstructors(){
        return instructorList;
    }

    //this simulates events of a day at school
    void aDayAtSchool(){

        // for any topic that does not have an open-for-registration course, create a new
        //course for that subject to start in 2 days
        for (Subject subject : subjectList){
            if(subject.getCourse()==null || subject.getCourse().isFinished() || subject.getCourse().isCancelled()){
                Course course = new Course(subject, 2);
                add(course);
                System.out.println("A new course for subject "+ subject.getDescription() + " has been created\n");
            }
        }

        //Look at each course that requires an instructor
        for (Course course : courseList){
            //if the course doesn't have an instructor and and it hasn't started yet
            if(!course.hasInstructor() && course.getStatus()<0){
                //go through the instructors until you find one that is free
                for(Instructor instructor : instructorList){
                    //not already teaching other courses and can teach the course
                    if(instructor.getAssignedCourse()==null && instructor.canTeach(course.getSubject())){
                        //assign the course to the instructor
                        instructor.assignCourse(course);

                        //assign the instructor to the course
                        course.setInstructor(instructor);

                        //break from the inner loop so that
                        // the next available instructor doesn't override the position
                        break;
                    }
                }
            }
        }

        //Look at each students
        for (Student student : studentList) {
            //if they are free
            if (student.getCourseEnrolledOn() == null) {
                //go through the courses until you find one that the student can join
                for (Course course : courseList) {
                    //if the course is not full, the student doesn't already have the certificate for the course
                    //and the course hasn't started yet
                    if (course.getSize() < 3 && !student.hasCertificate(course.getSubject())
                            && course.getStatus() < 0) {
                        /*
                        *  EXTENSION IMPLEMENTATION
                        */
                        //the required certificate a student needs to have in order to enrol in a course
                        //(i.e. in order to enrol in a course with subject id 3 the student needs to
                        //already have certificates for subjects with id 1 and 2)
                        int reqCeritificate = course.getSubject().getID() - 1;

                        //if a course's subject has id 1 any student in the school can enroll
                        //if a course's subject is higher than 1 the student needs to have the prerequisites for that course
                        if (course.getSubject().getID() == 1 ||
                                (course.getSubject().getID() != 1 && student.getCertificates().contains(reqCeritificate))) {

                            //enroll the student on the course
                            course.enrolStudent(student);

                            //assign the course the student is enrolled on to the student
                            student.setCourseEnrolledOn(course);

                            //breaks out of the inner loop
                            //so that the same student doesn't enroll in 2 courses at the same time
                            break;
                        }
                    }
                }
            }
        }

        //iterator object to iterate over the list of courses in the school
        Iterator<Course> iterator = courseList.iterator();

        //while loop that iterates ove the list
        while(iterator.hasNext()){
            Course course = iterator.next();

            //call aDayPasses on each course(let the students learn)
            course.aDayPasses();

            //remove the course from the school if it has been cancelled
            if(course.isCancelled()){
                System.out.println("The course with the subject named: " + course.getSubject().getDescription() + " has been cancelled\n");
                iterator.remove();
            }

            //remove the course from the school if it has finished
            if(course.isFinished()){
                System.out.println("The course with the subject named: " + course.getSubject().getDescription() + " has finished\n");
                iterator.remove();
            }
        }
    }

    @Override
    //this overrides the method returning a pretty-print string of the school
    public String toString(){

        //string that will be modified with details about courses
        String courseString = "The scholl named " + name + " has the following courses each with:"+"\n\n***************************\n";

        //if the course list is not empty loop over each course and add information about each course to the courseString
        if(courseList.size()!=0) {
            for (Course course : courseList) {

                //subject: description, id, specialism and duration
                if (course.hasSubject()) {
                    courseString = courseString + " - a subject that has -->" + " description: " + course.getSubject().getDescription() + ", ID: " + course.getSubject().getID() +
                            ", specialism: " + course.getSubject().getSpecialism() + ", duration: " + course.getSubject().getDuration() + "\n";
                }

                //instructor: name, gender, age
                if (course.hasInstructor()) {
                    courseString = courseString + " - an instructor that has --> name: " + course.getInstructor().getName() +
                            ", gender: " + course.getInstructor().getGender() + ", age: " + course.getInstructor().getAge() + "\n";
                }

                //student:name, gender, age, certificates(if any)
                if (course.getSize() != 0) {
                    for (Student student : course.getStudents()) {
                        courseString = courseString + " - a student that has --> name: " + student.getName() +
                                ", gender: " + student.getGender() + ", age: " + student.getAge() ;

                        //if the student has certificates
                        if(student.getCertificates().size()!=0){
                            courseString = courseString + ", certificates: ";

                            //loops over the list of certificates and adds them to the courseString
                            for(Integer certificate : student.getCertificates()){
                                courseString = courseString + certificate +" ";
                            }
                            courseString =courseString + "\n";
                        }else{
                            courseString = courseString + "\n";
                        }
                    }
                }

                //this is used to separate each course from one another
                courseString = courseString + "\n***************************\n\n";
            }
        }

        //string that will be modified with details about instructors
        String instructorString ="Instructors in the school:\n";

        //if the instructor list is not empty
        if(!instructorList.isEmpty()) {

            //loops over the list of instructors and adds to the instructorString details about them
            for(Instructor instructor : instructorList) {
                instructorString = instructorString + " - an instructor that has --> name: " + instructor.getName() +
                        ", gender: " + instructor.getGender() + ", age: " + instructor.getAge() + "\n";
            }
        }

        //string that will be modified with details about students
        String studentString ="Students in the school:\n";

        //if the student list is not empty
        if(!studentList.isEmpty()) {

            //loops over the list of students and adds to the studentString details about them
            for(Student student : studentList) {
                studentString = studentString + " - a student that has --> name: " + student.getName() +
                        ", gender: " + student.getGender() + ", age: " + student.getAge() ;

                //id the student has certificates
                if(student.getCertificates().size()!=0){
                    studentString = studentString + ", certificates: ";

                    //loop over the list of certificates and add them to the string
                    for(Integer certificate : student.getCertificates()){
                        studentString = studentString + certificate +" ";
                    }
                    studentString =studentString + "\n";
                }else{
                    studentString = studentString + "\n";
                }
            }
        }

        //return the combination of each string (which will be followed by printed out updates)
        return  ( courseString + instructorString + studentString +"\n END OF THE DAY UPDATES:\n");
    }
}
