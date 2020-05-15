package com.company;
// comparator interface example

import java.util.Comparator;

public class Student {
    //we use static for nested classes to make sure that there is only one Comparator for the entire class
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();
    private final String name;
    private final int section;

    public Student(String name, int section){
        this.name = name;
        this.section = section;
    }

    private static class ByName implements Comparator<Student>{
        public int compare(Student v, Student w){
            return v.name.compareTo(w.name);
        }
    }

    private static class BySection  implements Comparator<Student>{
        public int compare(Student v, Student w){
            return v.section- w.section;
        }
    }

}
