package util;

import bean.Student;
import store.AppStorage;

import java.util.Scanner;

import static util.MenuUtil.*;

public class StudentUtil {

    public static void showMenuStudent() {
        while (true) {
            System.out.println("Please choose action from menu:\n" +
                    "1. Register student:\n" +
                    "2. Delete student:\n" +
                    "3. Find student:\n" +
                    "4. Show all student:\n" +
                    "5. Return main menu:\n" +
                    "6. Exit:\n");
            int menuId = new Scanner(System.in).nextInt();
            if (menuId == 1) {
                registerStudent();
            } else if (menuId == 2) {
                deleteStudent();
            } else if (menuId == 3) {
                findStudent();
            } else if (menuId == 4) {
                showAllStudent();
            } else if (menuId == 5) {
                showMenu();
            } else if (menuId == 6) {
                System.exit(0);
            } else {
                System.out.println("menu id is wrong. Please choose again");
            }
        }
    }

    public static Student registerStudent() {
        Student student = new Student(AppStorage.currentStudentIndex + 1, requireString("Enter name:"),
                requireString("Enter surname:"), requireDouble("Enter scholarship:"));
        AppStorage.students[AppStorage.currentStudentIndex++] = student;
        System.out.println("Student successfully registered: " + student);
        return student;
    }

    public static void deleteStudent() {
        showAllStudent();
        int id = requireInteger("type student id to delete:");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null && AppStorage.students[i].getId() == id) {
                System.out.println("Student successfully deleted: " + AppStorage.students[i]);
                AppStorage.students[i] = null;
                break;
            }
        }
        showAllStudent();
    }

    public static void findStudent() {
        String findKey = requireString("type name,surname or id to find student");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null) {
                if (AppStorage.students[i].toString().contains(findKey)) {
                    System.out.println("Student founded " + AppStorage.students[i]);
                }
            }
        }
    }

    public static Student findStudentById(int id) {
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null) {
                if (AppStorage.students[i].getId() == id) {
                    return AppStorage.students[i];
                }
            }
        }
        return null;
    }

    public static void showAllStudent() {
        System.out.println("All student:");
        for (int i = 0; i < AppStorage.students.length; i++) {
            if (AppStorage.students[i] != null) {
                System.out.println(AppStorage.students[i]);
            }
        }
    }
}
