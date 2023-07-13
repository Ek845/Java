import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Seminar_3_1 {
    public static void main(String[] args) {
        // Дан произвольный список чисел.
        // 1. УДдалить из него чётные числа
        // 2. Найти минимальное значение
        // 3. Найти максимальное значение
        // 4. Найти среднее значение

        ArrayList<Integer> finalList = randomArrayList(10, 10);
        System.out.println(finalList.toString());
        int min = minValue(finalList, 10);
        System.out.println(min);
        int max = maxValue(finalList);
        System.out.println(max);
        double aver = averageValue(finalList);
        System.out.println(aver);
        removingNums(finalList);
        System.out.println(finalList.toString());
    }

    static ArrayList<Integer> randomArrayList(int size, int maxValue) {
        Random r = new Random();
        ArrayList<Integer> newRandomAr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            newRandomAr.add(r.nextInt(maxValue + 1));
        }
        return newRandomAr;
    }
    
    static void removingNums(ArrayList<Integer> finalArray) {
        Iterator<Integer> iter = finalArray.iterator();
        while (iter.hasNext()) {
            if (iter.next() % 2 == 0) {
                iter.remove();
            } 
        }
    }

    static int minValue(ArrayList<Integer> finalArray, int maxValue) {
        int m = maxValue + 1;
        for (int i = 0; i < finalArray.size(); i++) {
            if (finalArray.get(i) < m)
            m = finalArray.get(i);
        } 
        return m;
    }

    static int maxValue(ArrayList<Integer> finalArray) {
        int maximum = -1;
        for (int i = 0; i < finalArray.size(); i++) {
            if (finalArray.get(i) > maximum)
            maximum = finalArray.get(i);
        }
        return maximum;
    }

    static double averageValue(ArrayList<Integer> finalArray) {
        Iterator<Integer> iter = finalArray.iterator();
        int amount_1 = 0;

    while (iter.hasNext())
        amount_1 += iter.next();

    double average = ((double)amount_1)/finalArray.size();
    
    return average;

    }
}
