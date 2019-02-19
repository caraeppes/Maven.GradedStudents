package io.zipcoder;

import java.util.ArrayList;

public class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(){}

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        for (Double d : examScores){
            this.examScores.add(d);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String examScores = "Exam Scores:\n";
        int counter = 1;
        for(Double d : this.examScores){
            examScores = examScores + "     Exam " + counter + " --> "  + d + "\n";
            counter++;
        }
        return examScores;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(Double examScore){
        this.examScores.add(examScore);
    }

    public Double[] getExamScoresArray(){
        Double[] scoresArray = new Double[this.examScores.size()];
        int index = 0;
        for(Double d : this.examScores){
            scoresArray[index]= d;
            index++;
        }
        return scoresArray;
    }


    public static void main(String[] args) {
        Double[] scores = {100.0, 90.0, 80.0, 95.0};
        Student s = new Student("cara", "eppes", scores);
        System.out.println(s.getExamScores());
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Double d : examScores){
            sum += d;
        }
        return sum / examScores.size();

    }

    public void setExamScore(int examToSet, Double scoreToSet) {
        examScores.set(examToSet - 1, scoreToSet);
    }

    @Override
    public String toString(){
        return "Student Name: " + firstName + " " + lastName +"\n> Average Score: " + getAverageExamScore() + "\n" +
                "> " + getExamScores();
    }

    @Override
    public int compareTo(Student o) {
        if (o.getAverageExamScore() - this.getAverageExamScore() != 0){
            if (o.getAverageExamScore() - this.getAverageExamScore() > 0){
                return 1;
            }
            else {
                return -1;
            }
        }
        else {
            return this.firstName.compareTo(o.firstName);
        }
    }
}