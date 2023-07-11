import java.io.File;
public class Seminar_2_1 {
 public static void main(String[] args) {

// Напишите метод, который определяет тип (расширение) файлов из текущей папки
// и выведет в консоль результат вида:
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла: 
// 4 Расширение файла: jpg

    String dirPath = System.getProperty("user.dir") + ("\\TestDir");
    System.out.println(dirPath);
    String[] catalog = getFileList(dirPath);
    defExt(catalog);
 }   
static String[] getFileList(String dirPath) {
    File currentList = new File(dirPath);
    return currentList.list();
}

static void defExt(String[] fileList) {
    for (int i = 0; i < fileList.length; i++) {
        int index = fileList[i].indexOf(".");
        String result = i + 1 + "Расширение файла: " + fileList[i].substring(index);
        System.out.println(result);
    }
}
}

