package task6;

import java.util.Scanner;

public class InputHandler {

    static Scanner sc = new Scanner(System.in);

    public static int getInt(String message) {
        System.out.println(message);
        int value = sc.nextInt();
        sc.nextLine();
        return (value >= 0) ? value : getInt("Enter a positive value: ");
    }

    public static String getString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

}
