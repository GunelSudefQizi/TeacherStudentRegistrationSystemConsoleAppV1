package util;

import java.util.Scanner;

import static util.StudentUtil.showMenuStudent;
import static util.TeacherUtil.showMenuTeacher;

public class MenuUtil {

    public static void showMenu() {
        System.out.println("Type Student or Teacher:");
        String typePerson = new Scanner(System.in).nextLine();
        if (typePerson.equalsIgnoreCase("student")) {
            showMenuStudent();
        } else {
            showMenuTeacher();
        }
    }

    public static String requireString(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextLine();
    }

    public static Double requireDouble(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextDouble();
    }

    public static Integer requireInteger(String title) {
        System.out.println(title);
        return new Scanner(System.in).nextInt();
    }
}
