package com.example.school;

public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = {};
    private int[] grades = {};

    public Student(String name, String address) {
        super(name, address);
    }

    public void addCourseGrade(String course, int grade) {
        if (!containsCourse(course)) {
            numCourses++;
            String[] newCourses = new String[numCourses];
            int[] newGrades = new int[numCourses];
            System.arraycopy(courses, 0, newCourses, 0, numCourses - 1);
            System.arraycopy(grades, 0, newGrades, 0, numCourses - 1);
            newCourses[numCourses - 1] = course;
            newGrades[numCourses - 1] = grade;
            courses = newCourses;
            grades = newGrades;
        }
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    private boolean containsCourse(String course) {
        for (String c : courses) {
            if (c.equals(course)) {
                return true;
            }
        }
        return false;
    }
}