package IODemo.PrintStream;

import java.util.Scanner;

/***
 *
 * system.in
 * system.out
 * system.err
 * */
public class Demo02 {
    public static void main(String[] args) {
        System.err.println("err");
        System.out.println("out");


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("清输入");
            System.out.println(scanner.nextLine());
        }
    }

}
