import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Seminar_3_2 {
    public static void main(String[] args) {
        // Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы

    Scanner sc = new Scanner(System.in);
    System.out.println("Введите количество планет: ");
    int n = sc.nextInt();
    sc.close();

    ArrayList<String> planet = new ArrayList<>() {
        {
            add("Mercury");
            add("Venus");
            add("Earth");
            add("Mars");
            add("Jupiter");
            add("Saturn");
            add("Uranium");
            add("Neptune");
        }
    };

    ArrayList<String> Planets = randomStringArray(planet, n);
    System.out.println(Planets.toString());
    Set<String> newSet = UnicPlanets(Planets);
    System.out.println(newSet.toString());

    }
    static ArrayList<String> randomStringArray(ArrayList<String> finalArray, int n) {
        Random r = new Random();
        ArrayList<String> newArray = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int randomNumber = r.nextInt(finalArray.size());
            String temp = finalArray.get(randomNumber);
            newArray.add(temp);
        }
        return newArray;
    }

    static Set<String> UnicPlanets(ArrayList<String> finalArray) {
        Set<String> Set_1 = Set.copyOf(finalArray);
        return Set_1;
    }
}
