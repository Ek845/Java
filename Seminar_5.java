import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;


public class Seminar_5 {
    public static void main(String[] args) {
         
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

        Map<String, LinkedList<String>> phoneBook = new HashMap<>();
        int n = -1;
        while (n != 3) {
            System.out.println("Выбор действия: 1 - добавить контакт, 2 - показать контакт, 3 - выйти");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            switch (n) {
                case 1:
                    phoneBook = AddPhoneBook(phoneBook);
                    break;
                case 2:
                    phoneBook = sortingPhoneBook(phoneBook);
                    System.out.println(phoneBook);
                    break;
            }
            sc.close();
        }
    }

    static Map<String, LinkedList<String>> AddPhoneBook(Map<String, LinkedList<String>> phoneBook) {
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.println("Введите фамилию и номер телефона через пробел: ");
        String[] words = sc.nextLine().split(" ");

        if (phoneBook.containsKey(words[0])) {
            phoneBook.get(words[0]).add(words[1]);
        } else {
            phoneBook.put(words[0], new LinkedList<>());
            LinkedList<String> temp = phoneBook.get((words[0]));
            temp.add(words[1]);
        }
        sc.close();
        return phoneBook;
    }

    static Map<String, LinkedList<String>> sortingPhoneBook(Map<String, LinkedList<String>> phoneBook) {
        Map<String, LinkedList<String>> sortedMap = phoneBook.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue().size()))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
        return sortedMap;
    }
}
    