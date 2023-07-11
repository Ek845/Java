import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Seminar_2_2 {
    public static void main(String[] args) throws SecurityException, IOException {
        int[] numbers = {2, 7, 9, 1,8, 14, 3};
        System.out.println(Arrays.toString(bubbleSorting(numbers)));
    }  
// Реализуйте алгоритм сортировки пузырьком числового массива, результат 
// после каждой итерациизапишите в лог-файл.

static int[] bubbleSorting(int[] listForSort) throws SecurityException, IOException {
    String pathFile = System.getProperty("user.dir") + "\\Java\\Seminar.txt";
    for(int i = listForSort.length - 1; i >= 1; i--) {
        for (int j = 0; j < i; j++) {
            if (listForSort[j] > listForSort[j + 1]) {
                int temp = listForSort[j];
                listForSort[j] = listForSort[j + 1];
                listForSort[j + 1] = temp;
            }
            addListToFile(listForSort, pathFile);
        }
        return listForSort;

static void addListToFile(int[] list, String pathToLogFile) throws SecurityException, IOException {
    try {
        File myFile = new File(pathToLogFile);
        FileWriter writer = new FileWriter(myFile, true);

        writer.write(Arrays.toString(list) + "\n");

        writer.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    }

}
    
    
}
