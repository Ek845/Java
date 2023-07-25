public class Seminar_6 {
    public static void main(String[] args) {
        // Реализуйте класс Cat, включающий в себя от трех полей и от двух методов, 
        // определяющих базовый функционал класса(за основу можно взять наработки с семинара). 
        // Создать два экземпляра класса Cat и вывести информацию о них на экран.
    
        Cat cat1 = new Cat("Барсик", 5, 'm', 6.5);
        Cat cat2 = new Cat("Мурка", 3, 'f', 4.2);

        cat1.drink();
        System.out.println(cat2.speak());
        cat1.aboutCat();
        cat2.aboutCat();
    }
    
}
