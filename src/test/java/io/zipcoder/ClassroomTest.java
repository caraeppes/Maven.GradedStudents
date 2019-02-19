package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class ClassroomTest {

    @Test
    public void ClassroomMaxStudentsConstructor(){
        // Given
        Integer maxStudents = 10;

        // When
        Classroom classroom = new Classroom(maxStudents);
        Integer actual = classroom.getStudents().length;

        // Then
        Assert.assertEquals(maxStudents, actual);
    }


    @Test
    public void ClassroomStudentsConstructor(){
        // Given
        Student[] expected = {new Student(), new Student(), new Student()};

        // When
        Classroom classroom = new Classroom(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void nullaryConstructorTest(){
        // Given
        Student[] expected = new Student[30];

        // When
        Classroom classroom = new Classroom();
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void getAverageExamScoreTest(){
        // Given
        Double[] scores1 = {100.0, 80.0, 90.0};
        Double[] scores2 = {70.0, 60.0, 50.0};
        Student student1 = new Student("Good", "Student", scores1);
        Student student2 = new Student("Bad", "Student", scores2);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom(students);
        Double expected = 75.0;

        // When
        Double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest(){
        // Given
        Student[] students = {};
        Classroom classroom = new Classroom(students);
        Double[] examScores = {100.0};
        Student student = new Student("Cara", "Eppes", examScores);
        Student[] expected = {student};

        // When
        classroom.addStudent(student);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeStudentTest(){
        // Given
        String firstName = "Cara";
        String lastName = "Eppes";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);
        Student student2 = new Student("Other", "Student", examScores);
        Student student3 = new Student("OtherOther", "Student", examScores);
        Student[] students = {student, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3, null};

        // When
        classroom.removeStudent("NOTASTUDENT", "NOTASTUDENT");

        // Then
        Assert.assertArrayEquals(students, classroom.getStudents());

        // When
        classroom.removeStudent(firstName, lastName);

        // Then
        Assert.assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    public void getStudentsByScoreTest(){
        // Given
        Double[] scores1 = {100.0, 80.0};
        Double[] scores2 = {100.0, 100.0};
        Double[] scores3 = {90.0, 90.0};
        Double[] scores4 = {50.0, 30.0};
        Student student1 = new Student("Good", "Student", scores1);
        Student student2 = new Student("Cara", "Eppes", scores2);
        Student student3 = new Student("Another", "GoodStudent", scores3);
        Student student4 = new Student("Bad", "Student", scores4);
        Student[] students = {student1, student2, student3, student4};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3, student1, student4};

        // When
        Student[] actual = classroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getGradebookTest(){
        // Given
        Double[] d1 = {100.0};
        Double[] d2 = {90.0};
        Double[] d3 = {80.0};
        Double[] d4 = {70.0};
        Double[] d5 = {60.0};
        Double[] d6 = {50.0};
        Double[] d7 = {40.0};
        Double[] d8 = {30.0};
        Double[] d9 = {20.0};
        Double[] d10 = {10.0};
        Student s1 = new Student("Cara", "Eppes", d1);
        Student s2 = new Student("Smarty", "Pants", d2);
        Student s3 = new Student("Good", "Student", d3);
        Student s4 = new Student("Average", "Joe", d4);
        Student s5 = new Student("Needs", "Improvement", d5);
        Student s6 = new Student("Halfway", "There", d6);
        Student s7 = new Student("Dont", "Care", d7);
        Student s8 = new Student("Dummy", "Dumb", d8);
        Student s9 = new Student("Dumber", "Dummy", d9);
        Student s10 = new Student("Dumbest", "Dumbdumb", d10);
        Student[] students = {s8, s3, s2, s4, s5, s10, s7, s1, s9, s6};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new TreeMap<>();
        expected.put(s1, "A");
        expected.put(s2, "A");
        expected.put(s3, "B");
        expected.put(s4, "C");
        expected.put(s5, "C");
        expected.put(s6, "C");
        expected.put(s7, "D");
        expected.put(s8, "D");
        expected.put(s9, "D");
        expected.put(s10, "F");

        // When
        Map<Student, String> actual = new TreeMap<>();
        actual = classroom.getGradebook();

        // Then
        Assert.assertEquals(expected.get(s1), actual.get(s1));
        Assert.assertEquals(expected.get(s2), actual.get(s2));
        Assert.assertEquals(expected.get(s3), actual.get(s3));
        Assert.assertEquals(expected.get(s4), actual.get(s4));
        Assert.assertEquals(expected.get(s5), actual.get(s5));
        Assert.assertEquals(expected.get(s6), actual.get(s6));
        Assert.assertEquals(expected.get(s7), actual.get(s7));
        Assert.assertEquals(expected.get(s8), actual.get(s8));
        Assert.assertEquals(expected.get(s9), actual.get(s9));
        Assert.assertEquals(expected.get(s10), actual.get(s10));

    }
}
