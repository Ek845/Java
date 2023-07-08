// Реализовать простой калькулятор

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;
public class Seminar_1_3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение, которое необходимо рассчитать: ");
        int a = sc.nextInt();
        String d = sc.next();
        int b = sc.nextInt();
        sc.close();

        switch (d) {
            case "+":
                int result_1 = addition(a, b);
                System.out.println(result_1);
                return; 
            
            case "-":
                int result_2 = subtraction(a, b);
                System.out.println(result_2);
                return;

            case "*":
                int result_3 = multiplication(a,b);
                System.out.println(result_3);
                return;
            
            case "/":
                int result_4 = division(a,b);
                System.out.println(result_4);
                return;

            default:
                System.out.println("Ошибка!");
            }
    }

    static int addition(int a, int b) {
        return a + b;
    }

    static int subtraction(int a, int b) {
        return a - b;
    }

    static int multiplication(int a, int b) {
        return a * b;
    }

    static int division(int a, int b) {
        return a / b;
    }
}
