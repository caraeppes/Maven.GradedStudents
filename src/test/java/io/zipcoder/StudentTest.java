package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void StudentConstructorTest() {
        // Given
        String actualFirstName = "Cara";
        String actualLastName = "Eppes";
        Double[] actualExamScores = {100.0, 90.0, 80.0, 95.0};

        // When
        Student student = new Student(actualFirstName, actualLastName, actualExamScores);
        String expectedFirstName = student.getFirstName();
        String expectedLastName = student.getLastName();
        Double[] expectedExamScores = student.getExamScoresArray();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertArrayEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void GetExamScoresTest(){
        // Given
        Double[] examScores1 = {100.0, 90.0, 80.0, 95.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Cara","Eppes", examScores1);
        Student student2 = new Student("Cara", "Eppes", examScores2);
        String expected1 = "Exam Scores:\n     Exam 1 --> 100.0\n     Exam 2 --> 90.0\n     Exam 3" +
                " --> 80.0\n     Exam 4 --> 95.0\n";
        String expected2 = "Exam Scores:\n";

        // When
        String actual1 = student1.getExamScores();
        String actual2 = student2.getExamScores();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void getNumberOfExamsTakenTest(){
        // Given
        Double[] examScores1 = {100.0, 90.0, 80.0, 95.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Cara","Eppes", examScores1);
        Student student2 = new Student("Cara", "Eppes", examScores2);
        Integer expected1 = examScores1.length;
        Integer expected2 = examScores2.length;

        // When
        Integer actual1 = student1.getNumberOfExamsTaken();
        Integer actual2 = student2.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void addExamScoreTest(){
        // Given
        Double[] examScores1 = {100.0, 90.0, 80.0, 95.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Cara","Eppes", examScores1);
        Student student2 = new Student("Cara", "Eppes", examScores2);
        Double scoreToAdd = 50.0;
        Double[] expected1 = {100.0, 90.0, 80.0, 95.0, scoreToAdd};
        Double[] expected2 = {scoreToAdd};

        // When
        student1.addExamScore(scoreToAdd);
        Double[] actual1 = student1.getExamScoresArray();
        student2.addExamScore(scoreToAdd);
        Double[] actual2 = student2.getExamScoresArray();

        // Then
        Assert.assertArrayEquals(expected1, actual1);
        Assert.assertArrayEquals(expected2, actual2);
    }


    @Test
    public void setExamGradeTest(){
        // Given
        Double[] examScores = {100.0, 90.0, 80.0, 95.0};
        Student student = new Student("Cara","Eppes", examScores);
        int examToSet = 2;
        Double scoreToSet = 1000.0;
        Double[] expected = {100.0, 1000.0, 80.0, 95.0};

        // When
        student.setExamScore(examToSet, scoreToSet);
        Double[] actual = student.getExamScoresArray();


        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void getAverageExamScoreTest(){
        // Given
        Double[] examScores1 = {100.0, 90.0, 80.0};
        Double[] examScores2 = {50.0};
        Student student1 = new Student("Cara","Eppes", examScores1);
        Student student2 = new Student("Cara", "Eppes", examScores2);
        Double expected1 = 90.0;
        Double expected2 = 50.0;

        // When
        Double actual1 = student1.getAverageExamScore();
        Double actual2 = student2.getAverageExamScore();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void toStringTest(){
        // Given
        Double[] examScores = {100.0, 90.0, 80.0};
        Student student = new Student("Cara","Eppes", examScores);
        String expected = "Student Name: Cara Eppes\n> Average Score: 90.0\n> Exam Scores:\n     Exam 1 --> 100.0\n     Exam 2 --> 90.0\n     Exam 3" +
        " --> 80.0\n";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }

}