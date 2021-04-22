package util;

import bean.Student;
import bean.Teacher;
import store.AppStorage;

import java.util.Scanner;

import static util.MenuUtil.*;
import static util.MenuUtil.requireString;

public class TeacherUtil {

    public static void showMenuTeacher() {
        while (true) {
            System.out.println("Please choose action from menu:\n" +
                    "1. Register teacher:\n" +
                    "2. Delete teacher:\n" +
                    "3. Find teacher:\n" +
                    "4. Show all teacher:\n" +
                    "5. Assign the student to the teacher:\n" +
                    "6. Show the teacher's current students:\n" +
                    "7. Return main menu:\n" +
                    "8. Exit:");
            int menuId = new Scanner(System.in).nextInt();
            if (menuId == 1) {
                registerTeacher();
            } else if (menuId == 2) {
                deleteTeacher();
            } else if (menuId == 3) {
                findTeacher();
            } else if (menuId == 4) {
                showAllTeacher();
            } else if (menuId == 5) {
                assignStudentToTheTeacher();
            } else if (menuId == 6) {
                showStudentOfTeacher();
            } else if (menuId == 7) {
                showMenu();
            } else if (menuId == 8) {
                System.exit(0);
            } else {
                System.out.println("menu id is wrong. Please choose again");
            }
        }
    }

    public static void registerTeacher() {
        Teacher teacher = new Teacher(AppStorage.currentTeacherIndex + 1, requireString("Enter name:"),
                requireString("Enter surname:"), requireDouble("Enter salary:"));
        AppStorage.teachers[AppStorage.currentTeacherIndex++] = teacher;
        System.out.println("Teacher successfully registered: " + teacher);
    }

    public static void deleteTeacher() {
        showAllTeacher();
        int id = requireInteger("type teacher id to delete:");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null && AppStorage.teachers[i].getId() == id) {
                System.out.println("Teacher successfully deleted: " + AppStorage.teachers[i]);
                AppStorage.teachers[i] = null;
                break;
            }
        }
        showAllTeacher();
    }

    public static void findTeacher() {
        String findKey = requireString("type name,surname or id to find teacher");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                if (AppStorage.teachers[i].print().contains(findKey)) {
                    System.out.println("Teacher founded " + AppStorage.teachers[i]);
                }
            }
        }
    }

    public static Teacher findTeacherById(int id) {
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                if (AppStorage.teachers[i].getId() == id) {
                    return AppStorage.teachers[i];
                }
            }
        }
        return null;
    }

    public static void showAllTeacher() {
        System.out.println("All teacher:");
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                System.out.println(AppStorage.teachers[i]);
            }
        }
    }

    public static void assignStudentToTheTeacher() {

        showAllTeacher();
        Teacher teacher = findTeacherById(requireInteger("Which above teachers you want to assign current student?:"));

        StudentUtil.showAllStudent();
        Student student = StudentUtil.findStudentById(requireInteger("Which above student you want to assign?:"));
        boolean isAlreadyAssigned = false;
        for (int i = 0; i < teacher.getStudentsofTeacher().length; i++) {
            if (teacher.getStudentsofTeacher()[i] != null && teacher.getStudentsofTeacher()[i].getId().equals(student.getId())) {
                System.out.println("Student " + teacher.getStudentsofTeacher()[i].getName() + " already assigned to the teacher: " + teacher.getName());
                isAlreadyAssigned = true;
                break;
            }
        }
        if (!isAlreadyAssigned) {
            teacher.getStudentsofTeacher()[teacher.indexOfStudents++] = student;
            System.out.println("Student " + student.getName() + " assigned to the teacher " + teacher.getName());
        }
    }

    public static void showStudentOfTeacher() {
        for (int i = 0; i < AppStorage.teachers.length; i++) {
            if (AppStorage.teachers[i] != null) {
                for (int j = 0; j < AppStorage.students.length; j++) {
                    if (AppStorage.students[j] != null) {
                        System.out.println("Student " + AppStorage.students[j].getName() + " is the student of the teacher " + AppStorage.teachers[i].getName());
                    }
                }
            }
        }
    }
}
