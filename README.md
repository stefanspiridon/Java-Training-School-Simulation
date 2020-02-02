# Java Training School Simulation
A simulation of a Java training school. This school will admit students and they will receive training by a team of specialist instructors.

# Getting Started
The simulation will start by taking the name of the configuration file and the duration (number of days) for the simulation.
In order to run the code from the command line the following commands must be used:
```
java Administrator
mySchool.txt       
100                
```

# Prerequisites
Latest version of [Java](https://www.java.com/en/download/).

# How the Java training school works
The school offers training courses on various Java’s related subjects. Some examples of subjects are
showed in Table 1. Each subject has a unique ID and belong to some area of specialism. The duration for the course
associated with each subject is specified. The specialism determines the type of instructors that can deliver
the course. For example, for the subject titled “Basics (variables, conditionals, methods, loop, etc.)” (with ID
“1”), the duration for a course covering the subject is 5 days. Furthermore, the subject belongs to
Specialism “1” and can be taught by any teachers. 

|      Subject     | ID | Specialism | Duration | Instructor |
| ---------------- |:--:| ---------- | -------- | ---------- |
|Basics (variables,<br>conditionals, methods,<br>loop, etc.)|1|1|5 days|Any teacher|
|Lab 1 (Basics)|2|2|2 days|Any Teacher <br>or Demonstrator|
|Arrays|3|1|3 days|Any Teacher|
|Algorithms|4|1|1 day|Any Teacher|
|Testing and Debugging|5|1|3 days|Any Teacher|
|Lab 2 (Advanced)|6|2|2 days|Any Teacher <br>or Demonstrator|
|Object-Oriented 1 (class,<br> inheritance, etc.)|7|3|6 days|OOTrainer|
|Object-Oriented 2 <br>(encapsulation, exception,<br> etc.)|8|3|7 days|OOTrainer|
|Lab 3 (Object-Oriented)|9|2|3 days|Any Teacher <br>or Demonstrator|
|Graphics|10|4|5 days|GUITrainer|
|Controllers|11|4|2 days|GUITrainer|
|Lab 4 (GUI)|12|2|3 days|Any Teacher <br>or Demonstrator

Table 1. Example of Subjects

There are a number of concepts, people, and procedures that contribute to this simulation:

**Students**: Students will be admitted to the school to study a number of subjects. These subjects need to be
taught by the instructors. A student can only enrol to at most ONE course at a time. Once the students have
graduated they can leave the school.<br>
**Courses**: The school will create courses to teach different subjects. Each course is associated with exactly
ONE subject. Each course will have a maximum 3 students and must be taught by an instructor.<br>
**Instructors**: The school will be staffed by a number of instructors. The instructors may have particular
specialisms that let them teach particular subjects. Some subjects can only be taught by instructors with
the right specialism. An instructor will teach at most ONE course at a time.<br>
**School**: For our purposes a school will manages the courses, students, and instructors.<br>
**Administrator**: The school administrator is in charge of registering/deregistering students and instructors
to the school.

Basic configuration files will look like the example below. 

school:ECS Java Training School<br>
subject:Basics,1,1,5<br>
subject:Lab 1,2,2,2<br>
subject:Arrays,3,1,4<br>
student:Peter,M,60<br>
student:John,M,22<br>
student:Annabelle,F,31<br>
student:Maggie,F,58<br>
student:Alex,M,23<br>
Teacher:Yvonne,F,55<br>
Demonstrator:Beth,F,45<br>
OOTrainer:Chris,M,62<br>
GUITrainer:Sarah,F,48<br>

The format for the school is: 
School:name<br>
The format for Subjects is: 
subject:description,subjectID,specialisationID,duration<br>
The format for Students is: 
student:name,gender,age<br>
The format for Instructors is: 
instructor_type:name,gender,age

# Authors
* Stefan Spiridon
