import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Seminar_4 {
    public static void main(String[] args) {
        // Даны два Deque, представляющие собой два целых числа.
        // Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
        // 1) Умножьье два числа и верните произведение в виде связанного списка;
        // 2) Сложите два числа и верните сумму в в иде связанного списка.
        // Одно или два числа должны быть отрицательными.

    int n = -1;
    StringBuilder stNum_1 = new StringBuilder();
    StringBuilder stNum_2 = new StringBuilder();
    while (n != 0) {
        System.out.println("Выберите операцию: 1 - ввести число; 2 - найти сумму чисел; 3 - найти произведение чисел; 4 - выйти ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

    switch (n) {
        case 1:
            List<StringBuilder> stNum = getData();
            stNum_1 = stNum.get(0);
            stNum_2 = stNum.get(1);
        break;

        case 2:
            addition(stNum_1, stNum_2);
        break;

        case 3:
            multipl(stNum_1, stNum_2);
        break;
    
        default:
            break;
        }
    }
}
    
    static void addition(StringBuilder num_1, StringBuilder num_2) {
        if (num_1.charAt(0) == '-' && !(num_2.charAt(0) == '-')) {
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1.deleteCharAt(0), num_2);
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = subtraction(dequeIntNum_2, dequeIntNum_1);
            System.out.println(sub);
        }
        else if (!(num_1.charAt(0) == '-') && num_2.charAt(0) == '-') {
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1, num_2.deleteCharAt(0));
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = subtraction(dequeIntNum_1, dequeIntNum_2);
            System.out.println(sub);
        }
        else if (!(num_1.charAt(0) == '-') && !(num_2.charAt(0) == '-')) { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1, num_2);
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = addition(dequeIntNum_1, dequeIntNum_2);
            System.out.println(sub);
        }
        else if ((num_1.charAt(0) == '-') && (num_2.charAt(0) == '-')) { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1.deleteCharAt(0), num_2.deleteCharAt(0));
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = addition(dequeIntNum_1, dequeIntNum_2);
            LinkedList<Character> charSub = new LinkedList<>();
            Iterator<Integer> itr2 = sub.iterator();
            while (itr2.hasNext()) {
                charSub.add(Character.forDigit((itr2.next()), 10));
            }
            charSub.add(0, '-');
            System.out.println(charSub);
        }
    }
    
    static void multipl(StringBuilder num_1, StringBuilder num_2) { 
        if (num_1.charAt(0) == '-' && !(num_2.charAt(0) == '-')) { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1.deleteCharAt(0), num_2);
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = multiplication(dequeIntNum_2, dequeIntNum_1);
            LinkedList<Character> charSub = new LinkedList<>();
            Iterator<Integer> itr2 = sub.iterator();
            while (itr2.hasNext()) {
                charSub.add(Character.forDigit((itr2.next()), 10));
            }
            charSub.add(0, '-');
            System.out.println(charSub);
        } 
        else if (!(num_1.charAt(0) == '-') && num_2.charAt(0) == '-') { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1, num_2.deleteCharAt(0));
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = multiplication(dequeIntNum_1, dequeIntNum_2);
            LinkedList<Character> charSub = new LinkedList<>();
            Iterator<Integer> itr2 = sub.iterator();
            while (itr2.hasNext()) {
                charSub.add(Character.forDigit((itr2.next()), 10));
            }
            charSub.add(0, '-');
            System.out.println(charSub);
        } 
        else if (!(num_1.charAt(0) == '-') && !(num_2.charAt(0) == '-')) { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1, num_2);
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = multiplication(dequeIntNum_1, dequeIntNum_2);
            System.out.println(sub);
        } 
        else if ((num_1.charAt(0) == '-') && (num_2.charAt(0) == '-')) { 
            List<Deque<Integer>> dequeuesIntNum = preNum(num_1.deleteCharAt(0),
                    num_2.deleteCharAt(0));
            Deque<Integer> dequeIntNum_1 = dequeuesIntNum.get(0);
            Deque<Integer> dequeIntNum_2 = dequeuesIntNum.get(1);
            LinkedList<Integer> sub = multiplication(dequeIntNum_1, dequeIntNum_2);
            System.out.println(sub);
        }
    }

    static List<StringBuilder> getData() { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        String stNum_1 = sc.nextLine();
        System.out.println("Введите второе число: ");
        String stNum_2 = sc.nextLine();
        StringBuilder stBNum_1 = new StringBuilder(stNum_1);
        StringBuilder stBNum_2 = new StringBuilder(stNum_2);
        return List.of(stBNum_1, stBNum_2);
    }

    static List<Deque<Integer>> preNum(StringBuilder stNum_1, StringBuilder stNum_2) { 
        Deque<Character> dequeCharNumber_1 = createDequeOfCharacters(stNum_1);
        Deque<Character> dequeCharNumber_2 = createDequeOfCharacters(stNum_2);
        Deque<Integer> dequeIntNumber_1 = convertToIntegerDeque(dequeCharNumber_1); 

        Deque<Integer> dequeIntNumber_2 = convertToIntegerDeque(dequeCharNumber_2);
        dequeIntNumber_1 = equalLengths(dequeIntNumber_1, dequeIntNumber_2).get(0); 
        dequeIntNumber_2 = equalLengths(dequeIntNumber_1, dequeIntNumber_2).get(1);
        return List.of(dequeIntNumber_1, dequeIntNumber_2);
    }

    static LinkedList<Integer> addition(Deque<Integer> deque_1, Deque<Integer> deque_2) { 

        LinkedList<Integer> sumDeque = new LinkedList<>();
        int tempDigit = 0;
        int iter = deque_1.size();
        for (int i = 0; i < iter; i++) {
            sumDeque.addFirst((deque_1.peekFirst() + deque_2.peekFirst() + tempDigit) % 10);
            tempDigit = (deque_1.pollFirst() + deque_2.pollFirst() + tempDigit) / 10;
            }
            if (tempDigit == 1)
                sumDeque.addFirst(1);
                return sumDeque;
            }
        
    static LinkedList<Integer> subtraction(Deque<Integer> deque_1, Deque<Integer> deque_2) { 
        LinkedList<Integer> subDeque = new LinkedList<>();
        int tempDigit = 0;
        int iter = deque_1.size();
        for (int i = 0; i < iter; i++) {
            if (deque_2.peekFirst() > deque_1.peekFirst()) {
                subDeque.addFirst((10 + deque_1.pollFirst() - deque_2.pollFirst() - tempDigit)); tempDigit = 1;
        }
            else  {
                subDeque.addFirst(deque_1.pollFirst() - deque_2.pollFirst() - tempDigit); 
                tempDigit = 0;
            } 
                }
                int k = 0;
                while (subDeque.get(k) == 0)
                subDeque.remove(k);
            return subDeque;
    }

    static Deque<Character> createDequeOfCharacters(StringBuilder Digit) { 
        Deque<Character> DequeOfCharacter = new LinkedList<>();
        for (int i = 0; i < Digit.length(); i++) {
            DequeOfCharacter.addFirst(Digit.charAt(i));
        }
        return DequeOfCharacter;
    }

    static Deque<Integer> convertToIntegerDeque(Deque<Character> number) { 
        Deque<Integer> intDequeNumber = new LinkedList<>();
        Iterator<Character> itr = number.iterator();
        while (itr.hasNext()) {
            intDequeNumber.addLast((Character.digit(itr.next(), 10)));
        }
        return intDequeNumber;
    }

    static List<Deque<Integer>> equalLengths(Deque<Integer> num_1, Deque<Integer> num_2) { 
        if (num_1.size() > num_2.size()) {
            for (int i = 0; i < num_1.size() - num_2.size(); i++) 
            num_2.addLast(0);
        } else {
            for (int i = 0; i < num_2.size() - num_1.size(); i++)
                num_1.addLast(0);
        }
        return List.of(num_1, num_2);
    }

    static LinkedList<Integer> multiplication(Deque<Integer> deque_1, Deque<Integer> deque_2) {
        int digit_1 = convertDequeToInt(deque_1);
        int digit_2 = convertDequeToInt(deque_2);
        int mult = digit_1 * digit_2;
        LinkedList<Integer> multList = new LinkedList<>();
        while (mult != 0) {
            multList.add(mult % 10);
            mult = mult / 10;
        }
        return multList;

    }

    static int convertDequeToInt(Deque<Integer> deque_1) {
        int sum = 0;
        int i = 1;
        while (!deque_1.isEmpty()) {
            sum += deque_1.pollLast() * i;
            i = i * 10;
        }
        return sum;
    }
}
