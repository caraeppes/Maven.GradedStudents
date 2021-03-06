package io.zipcoder;


import java.util.*;

public class Classroom {

    private Student[] students;


    public Classroom(int maxStudents){
        this.students = new Student[maxStudents];
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for(Student s : students){
            sum += s.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        Student[] newStudents = new Student[students.length + 1];
        int index = 0;
        for (Student s : students){
            newStudents[index] = s;
            index++;
        }
        newStudents[index] = student;
        this.students = newStudents;
    }

    public void removeStudent(String firstName, String lastName) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        Student studentToRemove = null;
        for (Student s : studentList){
            if ((s.getLastName().equals(lastName)) && (s.getFirstName().equals(firstName))){
                studentToRemove = s;
            }
        }
        if (studentToRemove != null){
            studentList.remove(studentToRemove);
            studentList.add(null);
        }
        students = studentList.toArray(students);
    }


    public Student[] getStudentsByScore() {
        Arrays.sort(students);
        return students;
    }


    public Map<Student,String> getGradebook(){
        Map<Student, String> gradebook = new TreeMap<>();
        Student[] sortedGrades = getStudentsByScore();
        Double percentile;
        Double classSize = new Double(sortedGrades.length);
        for (int i = 0; i < sortedGrades.length; i++){
            percentile = (((classSize - i) / classSize) * 100.0);
            if (percentile >= 90){
                gradebook.put(sortedGrades[i], "A");
            }
            else if(percentile >= 71){
                gradebook.put(sortedGrades[i], "B");
            }
            else if(percentile >= 50){
                gradebook.put(sortedGrades[i], "C");
            }
            else if(percentile >= 11){
                gradebook.put(sortedGrades[i], "D");
            }
            else{
                gradebook.put(sortedGrades[i], "F");
            }
        }
        return gradebook;
    }
}
