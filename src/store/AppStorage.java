package store;

import bean.Student;
import bean.Teacher;

public class AppStorage {
    public static Student[] students =new Student[100];
    public static int currentStudentIndex=0;

    public static Teacher[] teachers =new Teacher[100];
    public static int currentTeacherIndex=0;
}
