// Вычислить n-ое треугольное число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

/**
 * Seminar_1
 */
import java.util.Scanner;
public class Seminar_1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = sc.nextInt();
        sc.close();
        int sum = amount(n);
        int fact = factorial(n);
        System.out.println("Сумма чисел от 1 до " + n + " равна " + sum);
        System.out.println("n" + "! = " + fact);
    }
    
    static int amount(int x) {
        int s = 0;
        for (int i = 1; i <= x; i++) {
            s += i;
        }
        return s;
    } 

    static int factorial(int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) {
            f *= i;
        }
        return f;
    }
}