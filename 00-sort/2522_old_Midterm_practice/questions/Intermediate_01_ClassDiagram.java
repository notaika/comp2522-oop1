package org.bcit.comp2522.winter2023.midterm_takeup.questions;

import java.util.ArrayList;

public class Intermediate_01_ClassDiagram {


  public class Teacher implements Teachable {
    private String name;
    private int id;
    private String subject;
    private Campus campus;
    private ArrayList<Student> students;

    public Teacher(String name, int id, String subject, Campus campus) {
      this.name = name;
      this.id = id;
      this.subject = subject;
      this.campus = campus;
      this.students = new ArrayList<>();
    }

    public String getName() {
      return name;
    }

    public int getId() {
      return id;
    }

    public String getSubject() {
      return subject;
    }

    public Campus getCampus() {
      return campus;
    }

    public ArrayList<Student> getStudents() {
      return students;
    }

    public class Tutor implements Teachable {
      private String name;
      private int id;
      private ArrayList<Course> courses;
      private ArrayList<Student> students;

      public Tutor(String name, int id, ArrayList<Course> courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
        this.students = new ArrayList<>();
      }

      public String getName() {
        return name;
      }

      public int getId() {
        return id;
      }

      public ArrayList<Course> getCourses() {
        return courses;
      }

      public ArrayList<Student> getStudents() {
        return students;
      }

      public String getSubject() {
        // Tutors can teach multiple courses, so we'll just return the subject of the first course
        if (courses.isEmpty()) {
          return "Unknown";
        }
        return courses.get(0).getTeacher().getSubject();
      }
    }

    public class Campus {
      private String name;
      private String location;
      private ArrayList<Student> students;
      private ArrayList<Tutor> tutors;
      private ArrayList<Program> programs;
      private ArrayList<Teachable> teachers;

      public Campus(String name, String location) {
        this.name = name;
        this.location = location;
        this.students = new ArrayList<>();
        this.tutors = new ArrayList<>();
        this.programs = new ArrayList<>();
        this.teachers = new ArrayList<>();
      }

      public String getName() {
        return name;
      }

      public String getLocation() {
        return location;
      }

      public ArrayList<Student> getStudents() {
        return students;
      }

      public ArrayList<Tutor> getTutors() {
        return tutors;
      }

      public ArrayList<Program> getPrograms() {
        return programs;
      }

      public ArrayList<Teachable> getTeachers() {
        return teachers;
      }
    }

    public class Program {
      private String name;
      private ArrayList<Course> courses;
      private ArrayList<Teacher> teachers;
      private ArrayList<Student> students;
      private Campus campus;

      public Program(String name, ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<Student> students, Campus campus) {
        this.name = name;
        this.courses = courses;
        this.teachers = teachers;
        this.students = students;
        this.campus = campus;
      }

      public String getName() {
        return name;
      }

      public ArrayList<Course> getCourses() {
        return courses;
      }

      public ArrayList<Teacher> getTeachers() {
        return teachers;
      }

      public ArrayList<Student> getStudents() {
        return students;
      }

      public Campus getCampus() {
        return campus;
      }
    }

    public class Student {
      private String name;
      private int id;
      private ArrayList<Course> courses;
      private Campus campus;

      public Student(String name, int id, ArrayList<Course> courses, Campus campus) {
        this.name = name;
        this.id = id;
        this.courses = courses;
        this.campus = campus;
      }

      public String getName() {
        return name;
      }

      public int getId() {
        return id;
      }

      public ArrayList<Course> getCourses() {
        return courses;
      }

      public Campus getCampus() {
        return campus;
      }
    }

    public class Course {
      private String name;
      private Teachable teacher;
      private ArrayList<Student> students;
      private Program program;

      public Course(String name, Teachable teacher, ArrayList<Student> students, Program program) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.program = program;
      }

      public String getName() {
        return name;
      }

      public Teachable getTeacher() {
        return teacher;
      }

      public ArrayList<Student> getStudents() {
        return students;
      }

      public Program getProgram() {
        return program;
      }
    }
  }
}
