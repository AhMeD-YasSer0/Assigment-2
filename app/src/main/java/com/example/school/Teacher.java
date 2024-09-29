package com.example.school;

public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {};

    public Teacher(String name, String address) {
        super(name, address);
    }

    public boolean addCourse(String course) {
        if (!containsCourse(course)) {
            numCourses++;
            String[] newCourses = new String[numCourses];
            System.arraycopy(courses, 0, newCourses, 0, numCourses - 1);
            newCourses[numCourses - 1] = course;
            courses = newCourses;
            return true;
        }
        return false;
    }

    public boolean removeCourse(String course) {
        if (containsCourse(course)) {
            int index = -1;
            for (int i = 0; i < numCourses; i++) {
                if (courses[i].equals(course)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                numCourses--;
                String[] newCourses = new String[numCourses];
                System.arraycopy(courses, 0, newCourses, 0, index);
                System.arraycopy(courses, index + 1, newCourses, index, numCourses - index);
                courses = newCourses;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
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